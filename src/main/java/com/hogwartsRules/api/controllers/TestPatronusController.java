package com.hogwartsRules.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.repositories.TestPatronusRepository;
import com.hogwartsRules.api.repositories.TestRepository;

@RestController
@CrossOrigin(origins = "*")
public class TestPatronusController {

	@Autowired
	private TestPatronusRepository testRepository;


	@Autowired
	protected MongoTemplate mongoTemplate;
}
