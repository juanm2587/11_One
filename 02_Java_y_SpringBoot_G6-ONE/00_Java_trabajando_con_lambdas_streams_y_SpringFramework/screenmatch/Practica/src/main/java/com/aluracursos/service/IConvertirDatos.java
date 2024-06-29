package com.aluracursos.service;

public interface IConvertirDatos {
	<T> T obtenerDatos(String json,Class<T> clase);
}
