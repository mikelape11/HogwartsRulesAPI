package com.hogwartsRules.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.repositories.TestRepository;
import com.hogwartsRules.api.models.Test;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

	@Autowired
	private TestRepository testRepository;
	@Autowired
	protected MongoTemplate mongoTemplate;

	@RequestMapping(path="/todosTest", method=RequestMethod.GET)
		public List<Test>getTest(){
		return (List<Test>) testRepository.findAll();
	}

	@RequestMapping(path="/añadirTest", method=RequestMethod.POST)
		public void añadirTest(@RequestBody(required=false) Test test){
		testRepository.save(test);
	}

	@RequestMapping(path="/getPreguntasRespuestas", method=RequestMethod.GET)
	public List<Test>getPreguntasResuestas(){
	return testRepository.findByOrderByNumPreguntaAsc();
}
}
