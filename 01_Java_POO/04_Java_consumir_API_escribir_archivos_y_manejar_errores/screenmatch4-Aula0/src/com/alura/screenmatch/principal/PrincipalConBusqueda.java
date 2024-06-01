package com.alura.screenmatch.principal;

import com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.alura.screenmatch.modelos.Titulo;
import com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
	public static void main(String[] args) throws IOException, InterruptedException {
//todo: hacer este mismo codigo en clases para que quede mas ordenado:
		//una clase para obtener las pelicuasl de omdb
		//una clase que se encargue de guardar las pelicuasl en un archivo
		//otra que trasforme de omdb a titulo
		Scanner sc = new Scanner(System.in);
		List<Titulo> titulos = new ArrayList<>();


		/*
		 * con la libreria Gson estamos creando clases a partir del Json API
		 * Creamos el objeto Gson*/
		Gson gson = new GsonBuilder()
				/*
				con GsonBuilder() y .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				creamos el objeto mas generico y de esta manera no nos preocupamos por las mayusculas
				del las variables de la API y las llamamos desde TituloOmdb
				 */
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				.setPrettyPrinting()//esto da el formato de json
				.create();

		while (true) {
			System.out.println("Escriba el nombre de la pelicula");
			var busqueda = sc.nextLine();

			if (busqueda.equalsIgnoreCase("salir"))
				break;

			String direccion = "https://www.omdbapi.com/?t=" +
					busqueda.replace(" ", "+")//TODO investigar y usar la class URLEncoder
					+ "&apikey=cd7a6ddc";

			try {
  /*Aquí se está creando una instancia de la clase HttpClient utilizando
  el método estático newHttpClient() de la clase HttpClient.
  Esta instancia de HttpClient se utilizará para enviar solicitudes HTTP.
   */
				HttpClient client = HttpClient.newHttpClient();
  /*Aquí se está creando un constructor de solicitud HTTP utilizando el método estático
  newBuilder() de la clase HttpRequest.
  Este constructor se utiliza para construir una solicitud HTTP.
  Tambien esta usando el patron usa el patron Builder
  */
				HttpRequest request = HttpRequest.newBuilder()
						//URI.create("AQUI PONEMOS LA URL")
						.uri(URI.create(direccion))
						/*
						Finalmente, se llama al método build() del constructor de la solicitud para construir
						la solicitud HTTP completa. Esto devuelve un objeto HttpRequest que representa
						la solicitud HTTP configurada según las especificaciones proporcionadas.*/
						.build();
    /*
    response llama a "client"*/
				HttpResponse<String> response = client
						//envia nuestra request con un "BodyHandlers" que interpreta el mensaje que vamos a recibir
						.send(request, HttpResponse.BodyHandlers.ofString());

				String json = response.body();//creamos la varaible "json" que sea igual a "response.body()"
				System.out.println(json);


				//pasamos a convertir una parte del json a una clase

				TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);

				System.out.println(miTituloOmdb);
    /*como el json original no tiene el parametro tenemos que suar una anotacion en la clase Titulo
    de nuestro proyecto
    */
				//Titulo miTitulo=gson.fromJson(json, Titulo.class);//convertimos Titulo a clase- esta linea nos da un Titulo


				Titulo miTitulo = new Titulo(miTituloOmdb);//vamos a crear un nuevo constructor con los parametros usados
				System.out.println("Titulo ya convertido: " + miTitulo);
				//al correr la app se rompe si encuentra un error tenemos que usar una excepcion para que no pase

				/*FileWriter escritura = new FileWriter("peliculas.txt");
				//vamos a crear un archivo y ahi vamos a escribir el objeto
				escritura.write(miTitulo.toString());
				escritura.close();*/

				titulos.add(miTitulo);

			} catch (NumberFormatException e) {
				System.out.println("Ocurrio un error: ");
				System.out.println(e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Error en la URI, verifique la direccion");
			} catch (ErrorEnConversionDeDuracionException e) {
				//aca creamos el catch con la excepcion personalizada
				System.out.println(e.getMessage());
			}
		}
		System.out.println(titulos);
		//aca creamos el archivo y escribimos los titulos
		FileWriter escritura = new FileWriter("titulos.json");
		escritura.write(gson.toJson(titulos));
		escritura.close();

		System.out.println("Finalizo la ejecucion del programa");
	}

}







