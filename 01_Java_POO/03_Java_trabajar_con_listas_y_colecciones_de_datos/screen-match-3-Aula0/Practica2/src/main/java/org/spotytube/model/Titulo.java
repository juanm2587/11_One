package org.spotytube.model;

public class Titulo {
  private String nombre;
  private int fechaLanzamiento;
  private double sumaEvaluaciones;
  private int totalEvaluaciones;
  private double duracion;

  public Titulo(String nombre, int fechaLanzamiento) {
    this.nombre = nombre;
    this.fechaLanzamiento = fechaLanzamiento;
  }

  public String getNombre() {
    return nombre;
  }

  public int getFechaLanzamiento() {
    return fechaLanzamiento;
  }

  public int getTotalEvaluaciones() {
    return totalEvaluaciones;
  }

  public double getDuracion() {
    return duracion;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setFechaLanzamiento(int fechaLanzamiento) {
    this.fechaLanzamiento = fechaLanzamiento;
  }

  public void setDuracion(double duracion) {
    this.duracion = duracion;
  }
  public void fichaTecnica(){
    System.out.println("El titulo de la cancion es: "+this.nombre);
    System.out.println("Se lanzo en: "+this.fechaLanzamiento);
    System.out.println("La cancion dura: "+this.duracion+" minutos");
  }



}
