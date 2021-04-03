package com.hogwartsRules.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.EleccionCasa;

public interface EleccionCasaRepository extends MongoRepository<EleccionCasa, String> {


	void deleteByidUsuario(String idUsuario);


}
