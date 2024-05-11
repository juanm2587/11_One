package org.spotytube;

import org.spotytube.model.Titulo;

public class Main {
  public static void main(String[] args) {
    Titulo cancion=new Titulo("la bicicleta",2016);
    System.out.println(cancion.getNombre()+" "+cancion.getFechaLanzamiento());

  }
}