package com.hogwartsRules.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Favoritos;

public interface FavoritosRepository extends MongoRepository<Favoritos, String>{

}
