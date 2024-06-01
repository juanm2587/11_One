package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
	public void guardarJson(Pelicula pelicula) throws IOException {
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		FileWriter esritura= new FileWriter(pelicula.title()+".json");
		esritura.write(gson.toJson(pelicula));
		esritura.close();
	}
}
