package com.alura.screenmatch.modelos;

import com.alura.screenmatch.calculos.Clasificable;

public class Pelicula extends Titulo implements Clasificable {
    private String director;

    public String getDirector() {
        return director;
    }

    /*creamos un constructor que tenga como parametro el nombre para pasar
    el nombre al construir el objeto y lo mismo hicimos con serie
     */
    public Pelicula(String nombre) {
        this.setNombre(nombre);
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) calculaMediaEvaluaciones() / 2;
    }

    @Override
    public String toString() {
        return "Pelicula: "+this.getNombre()+" ("+getFechaDeLanzamiento()+")";
    }
}
