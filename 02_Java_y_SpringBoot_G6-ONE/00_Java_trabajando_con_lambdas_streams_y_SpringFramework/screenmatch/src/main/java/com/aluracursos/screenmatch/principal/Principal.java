package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	private Scanner sc=new Scanner(System.in);
	private ConsumoAPI consumoApi=new ConsumoAPI();
	private final String URL_BASE="https://www.omdbapi.com/?t";
	private final String API_KEY="&apikey=cd7a6ddc";
	private ConvierteDatos conversor=new ConvierteDatos();


	public void mostrarElMenu(){
		System.out.println("Escribe el nombre de la serie que deas buscar:");
		//busca datos de la serie
		var nombreSerie=sc.nextLine();
		var json=consumoApi.obtenerDatos(URL_BASE+nombreSerie.replace(" ","+")+API_KEY);
		//replace, reemplaza un caracter por otro, en este caso un espacio por una concatenacion
		DatosSerie datos=conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);
		//busca los datos de todas las temporadas
		List<DatosTemporada> temporadas=new ArrayList<>();
		for (int i = 1; i <=datos.totalDeTemporadas() ; i++) {
			json=consumoApi.obtenerDatos(URL_BASE+nombreSerie.replace(" ","+")+"&Season="+i+API_KEY);
			DatosTemporada datosTemporadas=conversor.obtenerDatos(json, DatosTemporada.class);
			temporadas.add(datosTemporadas);
		}
		temporadas.forEach(System.out::println);


	}
}
