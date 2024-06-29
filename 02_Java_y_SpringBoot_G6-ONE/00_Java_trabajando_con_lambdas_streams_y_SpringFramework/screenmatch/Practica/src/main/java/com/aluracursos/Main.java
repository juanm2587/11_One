package com.aluracursos;

import com.aluracursos.model.DatosPelicula;
import com.aluracursos.service.ConsumirAPI;
import com.aluracursos.service.ConvertirDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumirAPI consumoAPI = new ConsumirAPI();
		String json = consumoAPI.obtenerDatos("https://swapi.dev/api/people/1/");
		System.out.println("JSON recibido: " + json);

		ConvertirDatos conversor = new ConvertirDatos();
		DatosPelicula datos = conversor.obtenerDatos(json, DatosPelicula.class);
		System.out.println("Datos convertidos: " + datos);
	}
}//todo: terminar este ejercicio
