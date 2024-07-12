package com.aluracursos.screenmatch.repository;

import com.aluracursos.screenmatch.model.Categoria;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie,Long> {//JpaRepository pide un generito T y un Id para la definicion
	Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);//metodo para buscar serie por titulo
	//top5
	List<Serie> findTop5ByOrderByEvaluacionDesc();
	List<Serie> findByGenero(Categoria categoria);
	//List<Serie> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas, Double evaluacion);
	//aca agrego "native querys" personalizadas para hacer busquedas pero como serian deficil de mantener usamos "Jpql"
	//
	@Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.evaluacion >= :evaluacion")//pasamos clases en la consulta, tambien usamos ":" que van a identificar en valor y no del atributo d ela clase
	List<Serie> seriesPorTemparadaYEvaluacion(int totalTemporadas, Double evaluacion);//pasamos como argumento totalTemporada y evaluacion como en el metodo anterior

	@Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:nombreEpisodio%")
	List<Episodio> episodiosPorNombre(String nombreEpisodio);

	@Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.evaluacion DESC LIMIT 5 ")
	List<Episodio> top5Episodios(Serie serie);

}
