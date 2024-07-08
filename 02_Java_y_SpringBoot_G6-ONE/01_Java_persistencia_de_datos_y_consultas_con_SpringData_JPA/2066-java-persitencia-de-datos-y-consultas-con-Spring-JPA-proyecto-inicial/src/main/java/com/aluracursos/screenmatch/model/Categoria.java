package com.aluracursos.screenmatch.model;

public enum Categoria {
	ACCION("Action"),//referencia a la categoria de la API
	ROMANCE("Romance"),
	COMEDIA("Comedy"),
	DRAMA("Drama"),
	CRIMEN("Crime");
	private String categoriaOmdb;
	//creo un constructor de categoria
	Categoria(String categoriaOmdb){
		this.categoriaOmdb=categoriaOmdb;
	}
	public static Categoria fromString(String text){
		for (Categoria categoria:Categoria.values()){
			if (categoria.categoriaOmdb.equalsIgnoreCase(text)){
				return categoria;
			}
		}
		throw new IllegalArgumentException("Ninguna categoria encontrada: "+text);
	}
}
