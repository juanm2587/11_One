package com.radio.principal;

import com.radio.model.Cancion;
import com.radio.model.MisFavoritos;
import com.radio.model.Podcast;

public class Main {
  public static void main(String[] args) {
    Cancion miCancion=new Cancion();
    miCancion.setTitulo("Forever");
    miCancion.setCantante("Kiss");

    Podcast miPodcast=new Podcast();
    miPodcast.setPresentador("Juan");
    miPodcast.setTitulo("Java Live");

    //Cacion
    for (int i = 0; i <100 ; i++) {
      miCancion.meGusta();
    }
    for (int i = 0; i <2000 ; i++) {
      miCancion.reproduce();
    }
    //Podcast
    for (int i = 0; i <100 ; i++) {
      miPodcast.meGusta();
    }
    for (int i = 0; i <8000 ; i++) {
      miPodcast.reproduce();
    }

    System.out.println("Total de reproducciones: "+miCancion.getTotalReproducciones());
    System.out.println("Total de Me Gusta: "+miCancion.getTotalDeMeGusta());

    MisFavoritos favoritos=new MisFavoritos();
    favoritos.adicione(miPodcast);
    favoritos.adicione(miCancion);
  }
}