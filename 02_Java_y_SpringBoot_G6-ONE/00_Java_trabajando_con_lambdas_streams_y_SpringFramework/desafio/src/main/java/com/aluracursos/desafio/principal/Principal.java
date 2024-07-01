package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.Datos;
import com.aluracursos.desafio.model.DatosLibros;
import com.aluracursos.desafio.service.ConsumoAPI;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
	private static final String URL_BASE="https://gutendex.com/books/";
	private ConsumoAPI conusmoAPI=new ConsumoAPI();
	private ConvierteDatos conversor=new ConvierteDatos();
	private Scanner teclado=new Scanner(System.in);



	public void muestraElMenu(){
		var json=conusmoAPI.obtenerDatos(URL_BASE);
		System.out.println(json);
		var datos=conversor.obtenerDatos(json,Datos.class);
		System.out.println(datos);

		//Top 10 mas descargados
		System.out.println("Los 10 mas descargados son");
		datos.resultados().stream()
				//ordenamos los datos y usamos el reversed para ordenarlos de mayor a menor
				.sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
				.limit(10)
				.map(l->l.titulo().toUpperCase())
				.forEach(System.out::println);

		//Busqueda de libros por nombre
		System.out.println("Ingrese el nombre del libro que desea buscar");
		var tituloLibro=teclado.nextLine();
		json=conusmoAPI.obtenerDatos(URL_BASE+"?search=" + tituloLibro.replace(" ","+"));
		var datosBusqueda=conversor.obtenerDatos(json,Datos.class);
		Optional<DatosLibros> librosbusquedo=datosBusqueda.resultados().stream()
				.filter(l->l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
				.findFirst();
		if(librosbusquedo.isPresent()){
			System.out.println("Libro encontrado ");
			System.out.println(librosbusquedo.get());
		}else{
			System.out.println("El libro no fue encontrado");
		}
		//trabajando con estadisticas
		DoubleSummaryStatistics est=datos.resultados().stream()
				.filter(d->d.numeroDeDescargas()>0)
				.collect(Collectors.summarizingDouble(DatosLibros::numeroDeDescargas));
		System.out.println("Cantidad media de descargar: "+est.getAverage());
		System.out.println("Cantidad maxima de descargas: "+est.getMax());
		System.out.println("Cantidad minima de descargas: "+est.getMin());
		System.out.println("Cantidad de registros evaluados para calcular las estadisticas: "+est.getCount());


	}
}
