package com.aluracursos.screenmatch_frases;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="frases")
@Getter
@Setter
public class Frase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String frase;
	private String personaje;
	private String poster;
}
