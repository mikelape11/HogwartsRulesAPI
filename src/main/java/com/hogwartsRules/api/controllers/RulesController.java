package com.hogwartsRules.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.models.Favoritos;
import com.hogwartsRules.api.models.Rules;
import com.hogwartsRules.api.repositories.RulesRepository;

@RestController
@CrossOrigin(origins = "*")
public class RulesController {


	@Autowired
	private RulesRepository rulesRepository;

	@Autowired
	protected MongoTemplate mongoTemplate;
	
	@RequestMapping(path="/todosRules", method=RequestMethod.GET)
    public List<Rules> getRules(){
        return (List<Rules>) rulesRepository.findAll();
    }
	
	@PostMapping("/registrarRules")
	public void registrarRules(@RequestBody Rules rules){
		rulesRepository.save(rules);
	}
	

	 @PutMapping("/actualizarRule")//Funcion para que un usuario desde el movil actualice sus datos
		public void actualizarRule(@RequestBody Rules rules) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(rules.get_id()));
	    	 Rules rule1 = mongoTemplate.findOne(query, Rules.class);
	    	 rule1.setComentarios(rules.getComentarios());
	    	 rulesRepository.save(rules);
	   }

	 @PutMapping("/eliminarFavorito")
		public void eliminarProductoFav(@RequestBody Rules rules) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(rules.get_id()));
	    	 Rules rules1 = mongoTemplate.findOne(query, Rules.class);
	    	 Update update = new Update().pull("favoritos",rules.getFavoritos().get(0));

	    	 mongoTemplate.findAndModify(query, update, Rules.class);

	   }
	
}
