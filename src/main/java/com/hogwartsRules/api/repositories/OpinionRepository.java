package com.hogwartsRules.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Opinion;

public interface OpinionRepository extends MongoRepository<Opinion, String>{

}
