package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")//esta anotacion sirve cuando tenemos una url que se repite lo usamos como base
public class SerieController {
	//Controller es el que tiene contacto directo con nuestro servidor
	@Autowired
	private SerieService servicio;
	@GetMapping()//como tenemos como base la URL="/series" no es necesario ponerlo en este metodo
	public List<SerieDTO> obtenerSeries() {
		return servicio.obtenerSeries();
	}
	@GetMapping("/top5")
	public List<SerieDTO>obtenerTop5(){
		return servicio.obtenerTop5();
	}
	@GetMapping("/lanzamientos")
	public List<SerieDTO>obtenerLanzamientosMasRecientes(){
		return servicio.obtenerLanzamientosMasRecientes();
	}
	@GetMapping("/{id}")
	public SerieDTO obtenerPorId(@PathVariable Long id){
		return servicio.obtenerPorId(id);
	}
	@GetMapping("/{id}/temporadas/todas")
	public List<EpisodioDTO>obtenerTodasLasTemporadas(@PathVariable Long id){
		return  servicio.obtenerTodasLasTemporadas(id);
	}
	@GetMapping("/{id}/temporadas/{numeroTemporada}")
	//tengo que respetar los nombres de los PathVariable, deben de ser los mismos que van en el @GetMapping
	public List<EpisodioDTO>obtenerTemporadasPorNumero(@PathVariable Long id,@PathVariable Long numeroTemporada){
		return servicio.obtenerTemporadasPorNumero(id,numeroTemporada);
	}
	@GetMapping("/categoria/{nombreGenero}")
	public List<SerieDTO>obtenerSeriesPorCatalogo(@PathVariable String nombreGenero){
		return servicio.obtenerSeriesPorCategoria(nombreGenero);
	}



}
