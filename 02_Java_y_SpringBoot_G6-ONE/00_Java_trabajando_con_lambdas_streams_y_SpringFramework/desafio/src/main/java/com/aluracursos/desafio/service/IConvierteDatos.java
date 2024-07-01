package com.aluracursos.desafio.service;

public interface IConvierteDatos {
	<T> T obtenerDatos(String json,Class<T> clase);
	/*metodo obtener datos de tipo generico (T)*/
}
