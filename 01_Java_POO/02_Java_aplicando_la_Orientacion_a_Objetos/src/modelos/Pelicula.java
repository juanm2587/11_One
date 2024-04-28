package modelos;

import calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
  String director;

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  @Override
  public int getClasificacion() {
    return (int)calcularMedia()/2;
  }
}
