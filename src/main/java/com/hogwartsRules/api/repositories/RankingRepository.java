package com.hogwartsRules.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Ranking;

public interface RankingRepository extends MongoRepository<Ranking, String>{

	List<Ranking> findAllByOrderByPuntosDesc();

	List<Ranking> findByUsuario(String usuario);

	List<Ranking> findByCasaHogwartsOrderByPuntosDesc(String casaHogwarts);

}
