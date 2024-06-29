package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}
	@Override
	public void run (String...args) throws Exception{
		Principal principal=new Principal();
		principal.mostrarElMenu();


		/*var consumoAPI=new ConsumoAPI();
		var json=consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=cd7a6ddc");
		System.out.println(json);
		ConvierteDatos conversor=new ConvierteDatos();
		//puedo reeemplazar el tipo "var" por DatosSerie
		var datos=conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);

		json=consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=cd7a6ddc");
		DatosEpisodio episodios=conversor.obtenerDatos(json, DatosEpisodio.class);
		System.out.println(episodios);

		List<DatosTemporada>temporadas=new ArrayList<>();
		for (int i = 1; i <=datos.totalDeTemporadas() ; i++) {
			json=consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season="+i+"&apikey=cd7a6ddc");
			var datosTemporadas=conversor.obtenerDatos(json, DatosTemporada.class);
			temporadas.add(datosTemporadas);
		}
		temporadas.forEach(System.out::println);
*/
	}

}
