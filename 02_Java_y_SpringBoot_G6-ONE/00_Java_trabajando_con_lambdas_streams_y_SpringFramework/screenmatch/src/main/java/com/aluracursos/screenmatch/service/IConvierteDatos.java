package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {

	/*Java también tiene tipos de datos genéricos, que funcionan utilizando <T>.
	Aquí, estamos identificando que estamos trabajando con tipos de datos genéricos.
	En este momento, no sabemos cuál será el retorno, entonces, lo declararemos como genérico.
	Puede retornar una cosa u otra. Y aquí dentro del método, además de este String, necesitaré
	pasar una clase también, que en este caso será de tipo genérico también, que se llamará clase.
	*/

	<T> T obtenerDatos(String json,Class<T> clase);

}
