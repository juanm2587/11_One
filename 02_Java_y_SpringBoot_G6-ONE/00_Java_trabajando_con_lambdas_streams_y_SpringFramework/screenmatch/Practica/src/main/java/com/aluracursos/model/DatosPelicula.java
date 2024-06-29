package com.aluracursos.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPelicula(
		@JsonAlias("name") String personaje,
		@JsonAlias("films") String peliculas,
		@JsonAlias("homeworld") String planetaDondeVive
) {
}
