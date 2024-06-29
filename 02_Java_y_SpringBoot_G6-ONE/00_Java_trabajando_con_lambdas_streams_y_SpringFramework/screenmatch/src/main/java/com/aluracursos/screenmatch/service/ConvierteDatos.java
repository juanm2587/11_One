package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos{
	//al implementar "IConvierteDatos" debemos de implementar los metodos que trae
	private ObjectMapper mapper=new ObjectMapper();

/*
 Aquí, ¿qué va a devolver? No nos devolverá null, nos devolverá un objeto del tipo
 ObjectMapper.readValue. Entonces, va a leer este valor y lo transformará. ¿Qué va a transformar?
 Este JSON que trae, ¿y en qué lo transformará? En esa clase que vamos a pasar.
 Entonces, voy a poner aquí .class. Entonces, son estos dos atributos que necesitará mi método,
 el JSON y la clase.
 */
	@Override//metodo generico
	public <T> T obtenerDatos(String json, Class<T> clase) {
		try {
			return mapper.readValue(json,clase);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
