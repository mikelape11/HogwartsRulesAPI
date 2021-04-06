package com.hogwartsRules.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.TestPatronus;

public interface TestPatronusRepository extends MongoRepository<TestPatronus, String> {

}
