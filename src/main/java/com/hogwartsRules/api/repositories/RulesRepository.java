package com.hogwartsRules.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Rules;

public interface RulesRepository extends MongoRepository<Rules, String>{
	

}
