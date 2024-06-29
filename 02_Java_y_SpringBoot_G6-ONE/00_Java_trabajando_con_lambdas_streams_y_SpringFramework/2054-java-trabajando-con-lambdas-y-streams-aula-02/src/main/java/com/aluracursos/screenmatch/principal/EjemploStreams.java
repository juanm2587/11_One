package com.aluracursos.screenmatch.principal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EjemploStreams {
	public void muestraEjemplo(){
		List<String> nombres= Arrays.asList("Hachi","More","Lupe","Fiona","Lili","Lulu");
		//stream me permite hacer varias operaciones con mi lista
		nombres.stream()
				.sorted()//este metodo ordena alfabeticamente
				.limit(4)//limita a imprimir los primero 4 datos ya ordenados de la lista
				.filter(n->n.startsWith("F"))//filtramos para que imprima los que empiecen con "F"
				.map(n->n.toUpperCase())//va a convertir en mayusculas el nombre encontrado
				.forEach(System.out::println);

	}
	public void muestraEjemplo2(){
		List<Integer>numeros=Arrays.asList(1,2,3,4,5,6,7,8,9);
		List<Integer>numerosPares=
				numeros.stream()
						.filter(n->n%2==0)
						.collect(Collectors.toList());
		System.out.println(numerosPares);
	}
	public void muestraEjemplo3(){
		List<String> palabras = Arrays.asList("Java", "Stream", "Operaciones", "Intermedias");

		List<Integer> tamaños = palabras.stream()
				.map(s -> s.length())
				.collect(Collectors.toList());

		System.out.println(tamaños);
	}
	public void saludo(){
		List<String> nombres = Arrays.asList("Juan", "Maria", "Pedro", "Ana");
	/*Las operaciones finales son aquellas que cierran el stream y devuelven un resultado concreto.
	 Algunas operaciones finales comunes son forEach, collect y count.
	 Veamos algunos ejemplos de operaciones finales:
	 ForEach: permite ejecutar una acción en cada elemento de la stream. Por ejemplo, podemos imprimir
	 cada elemento de la lista.
	java*/
		nombres.stream()
				.forEach(nombre -> System.out.println("Hola, " + nombre + "!"));
	}
	public void ejemploColeccion(){
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	/*
	Collect: permite recopilar los elementos de la stream en una colección o en otro tipo de dato.
	Por ejemplo, podemos recopilar los números pares en un conjunto.
	 */
		Set<Integer> numerosPares = numeros.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toSet());

		System.out.println(numerosPares); // Salida: [2, 4, 6, 8, 10]
	}
}
