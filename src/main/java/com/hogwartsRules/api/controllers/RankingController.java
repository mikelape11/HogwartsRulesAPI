package com.hogwartsRules.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.models.Ranking;
import com.hogwartsRules.api.repositories.RankingRepository;

@RestController
@CrossOrigin(origins = "*")
public class RankingController {

	
	@Autowired
	private RankingRepository rankingRepository;

	@Autowired
	protected MongoTemplate mongoTemplate;
	

	@GetMapping("/getOrdenado")//Funcion para recoger todos los ranking ordenados
	public List<Ranking> getRankingOrdenadoPorPuntuacion(){
		 return rankingRepository.findAllByOrderByPuntosDesc();
	}
	
	@GetMapping("/getOrdenado/{casaHogwarts}")//Funcion para recoger todos los ranking ordenados por casa
	public List<Ranking> getPreguntaRuta(@PathVariable String casaHogwarts){
		return rankingRepository.findByCasaHogwartsOrderByPuntosDesc(casaHogwarts);
	}

	
	@PostMapping("/nuevoRanking")
	  public void insertarRanking(@RequestBody Ranking ranking) {
		rankingRepository.save(ranking);
	 }
	
	@DeleteMapping("/borrarRankingUsuario/{usuario}")
	public void borrarRankingUsuario(@PathVariable String usuario){
		List<Ranking> ranking = rankingRepository.findByUsuario(usuario);
		rankingRepository.deleteAll(ranking);
	}
	

}
