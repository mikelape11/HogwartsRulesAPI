package com.hogwartsRules.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.repositories.TestRepository;
import com.hogwartsRules.api.repositories.TestVaritaRepository;

@RestController
@CrossOrigin(origins = "*")
public class TestVaritaController {

	@Autowired
	private TestVaritaRepository testRepository;


	@Autowired
	protected MongoTemplate mongoTemplate;

}
