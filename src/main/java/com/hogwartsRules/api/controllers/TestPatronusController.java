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

import com.hogwartsRules.api.models.TestPatronus;
import com.hogwartsRules.api.models.TestPatronus;
import com.hogwartsRules.api.repositories.TestPatronusRepository;
import com.hogwartsRules.api.repositories.TestRepository;

@RestController
@CrossOrigin(origins = "*")
public class TestPatronusController {

	@Autowired
	private TestPatronusRepository testRepository;


	@Autowired
	protected MongoTemplate mongoTemplate;
	
	
	@RequestMapping(path="/todosPatronus", method=RequestMethod.GET)
	public List<TestPatronus>getPatronus(){
	return (List<TestPatronus>) testRepository.findAll();
}
	
	@RequestMapping(path="/añadirPatronus", method=RequestMethod.POST)
	public void añadirPatronus(@RequestBody(required=false) TestPatronus test){
	TestPatronus numeroPre = testRepository.findTop1ByOrderByNumPreguntaDesc();
	if(numeroPre == null) {
		test.setNumPregunta(1);
	}else {
		test.setNumPregunta(numeroPre.getNumPregunta()+1);
	}
	testRepository.save(test);
}

@RequestMapping(path="/editarPatronus", method=RequestMethod.POST)
	public void editarPatronus(@RequestBody(required=false) TestPatronus test){
	Query query = new Query(Criteria.where("_id").is(test.get_id()));
	Update update2 = new Update().set("pregunta",test.getPregunta()).set("respuestas", test.getRespuestas());
	mongoTemplate.updateMulti(query, update2,TestPatronus.class);
}

@RequestMapping(path="/getPreguntasRespuestasPatronus", method=RequestMethod.GET)
	public List<TestPatronus>getPreguntasResuestas(){
	return testRepository.findByOrderByNumPreguntaAsc();
}

@RequestMapping(path="/getPreguntasPatronus", method=RequestMethod.GET)
public TestPatronus getPreguntaByNum(@RequestBody(required=false) int numero) {

	TestPatronus test = testRepository.findByNumPregunta(numero);
	return test;
}

@RequestMapping(path="/eliminarPatronus", method=RequestMethod.DELETE)
public void eliminarTest(@RequestBody(required=false) TestPatronus id) {
	testRepository.deleteById(id.get_id());
}
}
