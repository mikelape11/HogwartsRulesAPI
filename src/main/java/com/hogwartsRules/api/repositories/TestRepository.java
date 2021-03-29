package com.hogwartsRules.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Test;

public interface TestRepository  extends MongoRepository<Test, String>{

	List<Test> findByOrderByNumPreguntaAsc();

}
