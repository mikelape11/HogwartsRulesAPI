package com.hogwartsRules.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Test;
import com.hogwartsRules.api.models.TestVarita;

public interface TestVaritaRepository extends MongoRepository<TestVarita, String> {

	TestVarita findTop1ByOrderByNumPreguntaDesc();

	List<TestVarita> findByOrderByNumPreguntaAsc();

	TestVarita findByNumPregunta(int numero);

}
