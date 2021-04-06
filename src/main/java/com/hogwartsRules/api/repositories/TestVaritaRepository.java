package com.hogwartsRules.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.TestVarita;

public interface TestVaritaRepository extends MongoRepository<TestVarita, String> {

}
