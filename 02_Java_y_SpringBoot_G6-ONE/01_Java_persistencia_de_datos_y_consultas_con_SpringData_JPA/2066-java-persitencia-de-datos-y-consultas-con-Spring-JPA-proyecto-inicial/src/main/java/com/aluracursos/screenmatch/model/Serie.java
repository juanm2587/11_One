package com.aluracursos.screenmatch.model;

import com.aluracursos.screenmatch.service.ConsultaChatGPT;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;
@Entity
@Table(name="series")
public class Serie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String titulo;
	private Integer totalTemporadas;
	private Double evaluacion;
	private String poster;
	@Enumerated(EnumType.STRING)//es el enumerado
	private Categoria genero;
	private String actores;
	private String sinopsis;
	//Ctrl+F buscamos y seleccionamos las concurencia que queremos cambiar
	/*@Transient sirve para no mapear esta lista para que no la usemos como ya hicimos la
	relacion entre serie y episodio ya no necesitamos la anotation
	 */
	//hace la relacion aca y tambien en la otra clase
	@OneToMany(mappedBy = "serie",cascade = CascadeType.ALL, fetch = FetchType.EAGER)// fetch agrega de forma peresosa o anciosa
	private List<Episodio>episodios;

	public Serie(){
		//JPA necesita tener un constructor predeterminado o vacio para funcionar
	}

	public Serie(DatosSerie datosSerie){
		this.titulo=datosSerie.titulo();
		this.totalTemporadas=datosSerie.totalTemporadas();
		//Optional nos va a permitir hacer transformacion de tipo de dato en este caso transformar a Double
		this.evaluacion= OptionalDouble.of(Double.valueOf(datosSerie.evaluacion())).orElse(0);
		this.poster=datosSerie.poster();
		this.genero=Categoria.fromString(datosSerie.genero().split(",")[0].trim());
		this.actores=datosSerie.actores();
		//en caso de poseer la API de chatPGT podemos usar la traduccion de sinopsis
		//this.sinopsis= ConsultaChatGPT.obtenerTraduccion(datosSerie.sinopsis());
		this.sinopsis=datosSerie.sinopsis();
	}


	@Override
	public String toString() {
		return
				"genero=" + genero +
				", titulo='" + titulo + '\'' +
				", totalTemporadas=" + totalTemporadas +
				", evaluacion='" + evaluacion + '\'' +
				", poster='" + poster + '\'' +
				", actores='" + actores + '\'' +
				", sinopsis='" + sinopsis + '\''+
				", episodios='" + episodios + '\'';
	}

	public List<Episodio> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(List<Episodio> episodios) {
		episodios.forEach(e->e.setSerie(this));
		this.episodios = episodios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getTotalTemporadas() {
		return totalTemporadas;
	}

	public void setTotalTemporadas(Integer totalTemporadas) {
		this.totalTemporadas = totalTemporadas;
	}

	public Double getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Double evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Categoria getGenero() {
		return genero;
	}

	public void setGenero(Categoria genero) {
		this.genero = genero;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
}
