package modelos;

public class Titulo {
  private String nombre;
  private int fechaLanzamiento;
  private int duracionEnMinutos;
  private boolean incluidoEnElPlan;
  private double sumaDeLasEvaluaciones;
  private int totalDeEvaluaciones;
  public void muestraFichaTecnica(){ //cuando se usa void es un metodo,si usamos un tipo de datos es una funcion
    System.out.println("El nombre de la pelicula: "+nombre);
    System.out.println("La fecha de lanzamiento: "+fechaLanzamiento);
    System.out.println("Duracion en minutos: "+getDuracionEnMinutos());
  }
  public void evaluacion(double nota){
    sumaDeLasEvaluaciones+=nota;
    totalDeEvaluaciones++;
  }
  public double calcularMedia(){
    return sumaDeLasEvaluaciones/totalDeEvaluaciones;
  }

  public int getTotalDeEvaluaciones() {
    return totalDeEvaluaciones;
  }

  public void setTotalDeEvaluaciones(int totalDeEvaluaciones) {
    this.totalDeEvaluaciones = totalDeEvaluaciones;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getFechaLanzamiento() {
    return fechaLanzamiento;
  }

  public void setFechaLanzamiento(int fechaLanzamiento) {
    this.fechaLanzamiento = fechaLanzamiento;
  }

  public int getDuracionEnMinutos() {
    return duracionEnMinutos;
  }

  public void setDuracionEnMinutos(int duracionEnMinutos) {
    this.duracionEnMinutos = duracionEnMinutos;
  }

  public boolean isIncluidoEnElPlan() {
    return incluidoEnElPlan;
  }

  public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
    this.incluidoEnElPlan = incluidoEnElPlan;
  }

  public Titulo() {
  }

  public Titulo(String nombre, int fechaLanzamiento, int duracionEnMinutos, boolean incluidoEnElPlan) {
    this.nombre = nombre;
    this.fechaLanzamiento = fechaLanzamiento;
    this.duracionEnMinutos = duracionEnMinutos;
    this.incluidoEnElPlan = incluidoEnElPlan;
  }
}
