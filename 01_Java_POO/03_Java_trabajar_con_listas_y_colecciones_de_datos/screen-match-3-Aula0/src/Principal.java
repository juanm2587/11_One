import com.alura.screenmatch.calculos.CalculadoraDeTiempo;
import com.alura.screenmatch.calculos.FiltroRecomendacion;
import com.alura.screenmatch.modelos.Episodio;
import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
  public static void main(String[] args) {
    Pelicula miPelicula = new Pelicula("Encanto");
    //pasamos el nombre por parametro al crear el objeto
    //miPelicula.setNombre("Encanto");
    miPelicula.setFechaDeLanzamiento(2021);
    miPelicula.setDuracionEnMinutos(180);
    System.out.println("Duración de la película: " + miPelicula.getDuracionEnMinutos());

    miPelicula.muestraFichaTecnica();
    miPelicula.evalua(8);
    miPelicula.evalua(5);
    miPelicula.evalua(10);
    System.out.println("Total de evaluaciones: " + miPelicula.getTotalDeEvaluaciones());
    System.out.println(miPelicula.calculaMediaEvaluaciones());


    Serie lost = new Serie("Lost");
    //lost.setNombre("Lost");
    lost.setFechaDeLanzamiento(2000);
    lost.muestraFichaTecnica();
    lost.setTemporadas(10);
    lost.setEpisodiosPorTemporada(10);
    lost.setMinutosPorEpisodio(50);
    System.out.println("Duracion de la série: " + lost.getDuracionEnMinutos());

    Pelicula otraPelicula = new Pelicula("Avatar");
    //otraPelicula.setNombre("Avatar");
    otraPelicula.setFechaDeLanzamiento(2023);
    otraPelicula.setDuracionEnMinutos(200);

    CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
    calculadora.incluido(miPelicula);
    calculadora.incluido(otraPelicula);
    calculadora.incluido(lost);
    System.out.println(calculadora.getTiempoTotal());

    FiltroRecomendacion filtro = new FiltroRecomendacion();
    filtro.filtra(miPelicula);

    Episodio episodio = new Episodio();
    episodio.setNumero(1);
    episodio.setSerie(lost);
    episodio.setTotalVisualizaciones(300);
    filtro.filtra(episodio);

    var peliculaDeBruno=new Pelicula("El senor de los anillo");
    //peliculaDeBruno.setNombre("El senor de los anillo");
    peliculaDeBruno.setDuracionEnMinutos(180);
    peliculaDeBruno.setFechaDeLanzamiento(2001);

    //creamos un arraylist de tipo Pelicula
    ArrayList<Pelicula> listaDePeliculas=new ArrayList<>();
    listaDePeliculas.add(peliculaDeBruno);//con add agregamos un objeto tipo Pelicula
    listaDePeliculas.add(miPelicula);
    listaDePeliculas.add(otraPelicula);

    System.out.println("Tamanio de la lista: "+listaDePeliculas.size());//size da el tamnio de la lista
    System.out.println("La primera pelicula es : "+listaDePeliculas.get(0).getNombre());
    //con .get(0) llamo al indice "0" que quiero usar y con .getNombre() llamo al atributo

    System.out.println(listaDePeliculas.toString());
    /*si llamamos de esta manera nos va a mostrar la referencia a memoria del objeto
    reescribimos el toString en la clase Pelicula para que nos devuelva la infor del objeto

     */

    System.out.println("el toString de la pelicula es: "+ listaDePeliculas.get(0));




  }
}