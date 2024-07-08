package com.aluracursos.screenmatch.model;

import com.aluracursos.screenmatch.service.ConsultaChatGPT;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.OptionalDouble;

public class Serie {
	private String titulo;
	private Integer totalTemporadas;
	private Double evaluacion;
	private String poster;
	private Categoria genero;
	private String actores;
	private String sinopsis;
	//Ctrl+F buscamos y seleccionamos las concurencia que queremos cambiar
	public Serie(DatosSerie datosSerie){
		this.titulo=datosSerie.titulo();
		this.totalTemporadas=datosSerie.totalTemporadas();
		//Optional nos va a permitir hacer transformacion de tipo de dato en este caso transformar a Double
		this.evaluacion= OptionalDouble.of(Double.valueOf(datosSerie.evaluacion())).orElse(0);
		this.poster=datosSerie.poster();
		this.genero=Categoria.fromString(datosSerie.genero().split(",")[0].trim());
		this.actores=datosSerie.actores();
		//en caso de poseer la API de chatPGT podemos usar la traduccion de sinopsis
		//this.sinopsis= ConsultaChatGPT.obtenerTraduccion(datosSerie.sinopsis());
		this.sinopsis=datosSerie.sinopsis();
	}


	@Override
	public String toString() {
		return
				"genero=" + genero +
				", titulo='" + titulo + '\'' +
				", totalTemporadas=" + totalTemporadas +
				", evaluacion='" + evaluacion + '\'' +
				", poster='" + poster + '\'' +
				", actores='" + actores + '\'' +
				", sinopsis='" + sinopsis + '\'';
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getTotalTemporadas() {
		return totalTemporadas;
	}

	public void setTotalTemporadas(Integer totalTemporadas) {
		this.totalTemporadas = totalTemporadas;
	}

	public Double getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Double evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Categoria getGenero() {
		return genero;
	}

	public void setGenero(Categoria genero) {
		this.genero = genero;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
}
