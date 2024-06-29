package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//esta anotacion va a ignorar todos los datos que no mapeamos de la API
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
		//cuando traemos los datos dela api toma el dato "Title" y lo mapea a "titulo"
		// convierte Tile a titulo para mi proyecto
		@JsonAlias("Title")	String titulo,
		@JsonAlias("totalSeasons") Integer totalDeTemporadas,
		@JsonAlias("imdbRating") String evaluacion) {
//@JsonAlias= solo sirve para leer
//@JsonProperty=sirve para leer y escribir

}
