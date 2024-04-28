import calculos.CalculadoraDeTiempo;
import calculos.FiltroRecomendacion;
import modelos.Episodio;
import modelos.Pelicula;
import modelos.Series;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    Pelicula miPelicula=new Pelicula();
    miPelicula.setNombre("Encanto");
    miPelicula.setFechaLanzamiento(2021);
    miPelicula.setDuracionEnMinutos(120);
    miPelicula.setIncluidoEnElPlan(true);



    Pelicula otraPelicula=new Pelicula();
    otraPelicula.setNombre("Matrix");
    otraPelicula.setFechaLanzamiento(2021);
    otraPelicula.setDuracionEnMinutos(180);
    otraPelicula.setIncluidoEnElPlan(true);


    miPelicula.muestraFichaTecnica();
    miPelicula.evaluacion(7.8);
    miPelicula.evaluacion(8.5);


    System.out.println(miPelicula.getTotalDeEvaluaciones());
    System.out.println(miPelicula.calcularMedia());

    otraPelicula.muestraFichaTecnica();


    Series casaDragon=new Series();
    casaDragon.setNombre("La casa del Dragon");
    casaDragon.setFechaLanzamiento(2022);
    casaDragon.setTemporadas(1);
    casaDragon.setMinutosPorEpisodio(50);
    casaDragon.setEpisodiosPorTemporada(10);

    casaDragon.muestraFichaTecnica();
    System.out.println(casaDragon.getDuracionEnMinutos());

    CalculadoraDeTiempo calculadora= new CalculadoraDeTiempo();
    calculadora.incluye(miPelicula);
    calculadora.incluye(casaDragon);
    calculadora.incluye(otraPelicula);
    System.out.println(calculadora.getTiempoTotal());

    FiltroRecomendacion filtroRecomendacion=new FiltroRecomendacion();
    filtroRecomendacion.filtro(miPelicula);

    Episodio episodio=new Episodio();
    episodio.setNumero(1);
    episodio.setNombre("La casa Dragon comienza");
    episodio.setSerie(casaDragon);
    episodio.setTotalVisualizaciones(50);
    filtroRecomendacion.filtro(episodio);




  }
}