package com.hogwartsRules.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.CrossOrigin;
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
		Test numeroPre = testRepository.findTop1ByOrderByNumPreguntaDesc();
		test.setNumPregunta(numeroPre.getNumPregunta()+1);
		testRepository.save(test);
	}

	@RequestMapping(path="/editarTest", method=RequestMethod.POST)
		public void editarTest(@RequestBody(required=false) Test test){
		Query query = new Query(Criteria.where("_id").is(test.get_id()));
		Update update2 = new Update().set("pregunta",test.getPregunta()).set("respuestas", test.getRespuestas());
		mongoTemplate.updateMulti(query, update2,Test.class);
	}

	@RequestMapping(path="/getPreguntasRespuestas", method=RequestMethod.GET)
		public List<Test>getPreguntasResuestas(){
		return testRepository.findByOrderByNumPreguntaAsc();
	}

	@RequestMapping(path="/getPreguntas", method=RequestMethod.GET)
	public Test getPreguntaByNum(@RequestBody(required=false) int numero) {

		Test test = testRepository.findByNumPregunta(numero);
		return test;
	}


}
