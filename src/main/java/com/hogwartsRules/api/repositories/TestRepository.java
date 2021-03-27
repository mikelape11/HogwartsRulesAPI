package com.hogwartsRules.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Test;

public interface TestRepository  extends MongoRepository<Test, String>{

}
