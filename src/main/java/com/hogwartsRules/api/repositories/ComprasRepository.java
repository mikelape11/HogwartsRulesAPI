package com.hogwartsRules.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Compras;

public interface ComprasRepository extends MongoRepository<Compras, String> {


}
