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

import com.hogwartsRules.api.models.Test;
import com.hogwartsRules.api.models.TestVarita;
import com.hogwartsRules.api.repositories.TestRepository;
import com.hogwartsRules.api.repositories.TestVaritaRepository;

@RestController
@CrossOrigin(origins = "*")
public class TestVaritaController {

	@Autowired
	private TestVaritaRepository testRepository;


	@Autowired
	protected MongoTemplate mongoTemplate;

	
	@RequestMapping(path="/todosVarita", method=RequestMethod.GET)
	public List<TestVarita>getVarita(){
	return (List<TestVarita>) testRepository.findAll();
}
	
	@RequestMapping(path="/añadirVarita", method=RequestMethod.POST)
	public void añadirVarita(@RequestBody(required=false) TestVarita test){
	TestVarita numeroPre = testRepository.findTop1ByOrderByNumPreguntaDesc();
	if(numeroPre == null) {
		test.setNumPregunta(1);
	}else {
		test.setNumPregunta(numeroPre.getNumPregunta()+1);
	}
	testRepository.save(test);
}

@RequestMapping(path="/editarVarita", method=RequestMethod.POST)
	public void editarVarita(@RequestBody(required=false) TestVarita test){
	Query query = new Query(Criteria.where("_id").is(test.get_id()));
	Update update2 = new Update().set("pregunta",test.getPregunta()).set("respuestas", test.getRespuestas());
	mongoTemplate.updateMulti(query, update2,TestVarita.class);
}

@RequestMapping(path="/getPreguntasRespuestasVarita", method=RequestMethod.GET)
	public List<TestVarita>getPreguntasResuestas(){
	return testRepository.findByOrderByNumPreguntaAsc();
}

@RequestMapping(path="/getPreguntasVarita", method=RequestMethod.GET)
public TestVarita getPreguntaByNum(@RequestBody(required=false) int numero) {

	TestVarita test = testRepository.findByNumPregunta(numero);
	return test;
}

@RequestMapping(path="/eliminarVarita", method=RequestMethod.DELETE)
public void eliminarTest(@RequestBody(required=false) TestVarita id) {
	testRepository.deleteById(id.get_id());
}
	
}
