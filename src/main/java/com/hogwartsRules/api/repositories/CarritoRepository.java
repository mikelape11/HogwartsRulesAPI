package com.hogwartsRules.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Carrito;

public interface CarritoRepository extends MongoRepository<Carrito, String>{

}
