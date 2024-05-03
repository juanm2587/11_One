package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
  public static void main(String[] args) {
    Pelicula miPelicula = new Pelicula("Encanto",2021);
    miPelicula.evalua(9);

    Pelicula otraPelicula = new Pelicula("Avatar",2023);
    otraPelicula.evalua(6);

    var peliculaDeBruno=new Pelicula("El senor de los anillo",2001);
    peliculaDeBruno.evalua(10);

    Serie lost = new Serie("Lost",2000);

    ArrayList<Titulo> lista=new ArrayList<>();
    /*Nuesta lista va a set de tipo TITULO, ya que esta alcanza a SERIE y a PELICULA
    *con add agregamos un objeto tipo Pelicula
    **/
    lista.add(miPelicula);
    lista.add(otraPelicula);
    lista.add(peliculaDeBruno);
    lista.add(lost);

    /*usamos un foreach para recorrer nuestra lista
    del lado derecho ponemos lo que queremos iterar("lista")
    del derecho como queremos llamar a cada item de esa lista(en este caso la llamamos "item")
    y despues el tipo de lista(en este caso una lista del tipo "Titulo")
     */
    for (Titulo item:lista){
      System.out.println(item.getNombre());
      //Pelicula pelicula=(Pelicula) item; aca casteamos el tipo item a Pelicula
      /*item pasa de ser de tipo "Titulo" a ser de tipo "Pelicula"
      y al ejecutar, este ejecuta bien hasta llegar a la serie lost que no es de tipo Pelicula
       */
      if(item instanceof Pelicula pelicula && pelicula.getClasificacion()>2 ){
        /*instanceof pregunta si la instancia es de tipo Pelicula y a su vez hace un casting de
        Pelicula pelicula y a su vez hace una operacion ( && pelicula.getClasificacion()>2)

         */
        System.out.println(pelicula.getClasificacion());
      }
    }
  /*metodos de imprimir un foreach
  1)  for (String nombre : nombres) {
        System.out.println(nombre);
    }
  2)  nombres.forEach(nombre -> System.out.println(nombre)); CON LAMBDA
  3)  nombres.forEach(System.out::println); con Method Reference(expresion reducida de lambda)
  * */

    List<String> listaDeArtistas=new LinkedList<>();
    //
    listaDeArtistas.add("Penelope Cruz");
    listaDeArtistas.add("Antonio Banderas");
    listaDeArtistas.add("Ricardo Darin");
    System.out.println("Lista de artistas desordenada: "+listaDeArtistas);
    //usando el metodo "Collections.sort" podemos ordenar listas
    Collections.sort(listaDeArtistas);
    System.out.println("Lista de artistas ordenada: "+listaDeArtistas);

    Collections.sort(lista);
    System.out.println("Lista de titulos ordenados: "+lista);

    //ordenar por fecha
    lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
    System.out.println("Lista Ordenada por fecha: "+lista);

  }
}
