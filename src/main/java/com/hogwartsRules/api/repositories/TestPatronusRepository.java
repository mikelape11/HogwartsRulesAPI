package com.hogwartsRules.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.TestPatronus;

public interface TestPatronusRepository extends MongoRepository<TestPatronus, String> {

	TestPatronus findByNumPregunta(int numero);

	List<TestPatronus> findByOrderByNumPreguntaAsc();

	TestPatronus findTop1ByOrderByNumPreguntaDesc();

}
