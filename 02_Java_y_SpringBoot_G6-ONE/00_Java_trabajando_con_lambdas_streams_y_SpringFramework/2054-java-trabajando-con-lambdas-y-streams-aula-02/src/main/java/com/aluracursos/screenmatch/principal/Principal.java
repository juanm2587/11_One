package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=cd7a6ddc";
    private ConvierteDatos conversor = new ConvierteDatos();
    public void muestraElMenu(){
        System.out.println("Escribe el nombre de la série que deseas buscar");
        //Busca los datos generales de las series
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        //https://www.omdbapi.com/?t=game+of+thrones&apikey=4fc7c187
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        //Busca los datos de todas las temporadas
        List<DatosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= datos.totalTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            DatosTemporada datosTemporada = conversor.obtenerDatos(json, DatosTemporada.class);
            temporadas.add(datosTemporada);
        }
        temporadas.forEach(System.out::println);

        /* //Mostrar solo el titulo de los episodios para las temporadas
        for (int i = 0; i < datos.totalTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }*/
        // Mejoría usando funciones Lambda
        //temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        //convertir todas las informaciones a una lista del tipo DatosEpisodio
        List<DatosEpisodio> datosEpisodios=temporadas.stream()
                .flatMap(t->t.episodios().stream())
                .collect(Collectors.toList());









        //top 5 episodios
        System.out.println("Top 5 episodios");
        datosEpisodios.stream()
                .filter(e->!e.evaluacion().equalsIgnoreCase("N/A"))
                .peek(e-> System.out.println("Primer filtro(N/A)"+e))//nuevo metodo
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .peek(e-> System.out.println("Segundo ordenacion (Mayor>Menor)"+e))
                .map(e->e.titulo().toUpperCase())
                .peek(e-> System.out.println("Tercero filtro mayusculas (Mayor>Menor)"+e))
                .limit(5)
                .forEach(System.out::println);
        //convirtiendo los datos a una Lista del tipo Episodio

        List<Episodio> episodios=temporadas.stream()
                .flatMap(t->t.episodios().stream()
                        .map(d->new Episodio(t.numero(),d)))
                .collect(Collectors.toList());
        //episodios.forEach(System.out::println);

        //busqueda de episodiosa partir de x anio
        System.out.println("ingrese el anio a partir del cual quieres ver los episodios");
        var fecha=teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda=LocalDate.of(fecha,1,1);

        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("dd/MM/yyyy");
        /*
        episodios.stream()
                .filter(e->e.getFechaDeLanzamiento() !=null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e-> System.out.println(
                        "Temporada "+e.getTemporada()+
                                "Episodio "+e.getTitulo()+
                                "Fecha de lanzamiento "+e.getFechaDeLanzamiento().format(dtf)
                ));
                */
    /*
    ¿Y qué es la función Peek?
    La función "peek" es una operación intermedia de una stream.
    Una operación intermedia es aquella que procesa los datos del stream pero no la finaliza, es decir,
    permite que se realicen más operaciones después de ella. La función peek se utiliza para "espiar"
    los elementos del stream sin alterarlos, lo que puede ser muy útil para la depuración.
    Esta función recibirá cada elemento del stream y realizará alguna operación con efecto secundario
    (como imprimir el elemento), pero devolverá el mismo elemento sin cambiar nada.

    ¿Por qué debería usar esto?
    El uso de Streams y la función peek puede ayudarte a escribir códigos más elegantes, fáciles
    de leer y reducir la posibilidad de errores. Además, pueden hacer que tu código se ejecute
    más rápido en ciertos casos, ya que los Streams permiten la paralelización de las operaciones,
    es decir, ejecutar varias operaciones al mismo tiempo.

    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

    int suma = numeros.stream()
                .peek(n -> System.out.println("Elemento: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Contenido después del map: " + n))
                .reduce(0, (total, numero) -> total + numero);

    System.out.println("La suma de los números es: " + suma);

     */







    }
}
