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

import com.hogwartsRules.api.models.Opinion;
import com.hogwartsRules.api.models.Test;
import com.hogwartsRules.api.models.Usuario;
import com.hogwartsRules.api.repositories.OpinionRepository;

@RestController
@CrossOrigin(origins = "*")
public class OpinionController {

	 @Autowired
	    private OpinionRepository opinionRepository;
	 @Autowired
	    protected MongoTemplate mongoTemplate;

	 @RequestMapping(path="/opiniones", method=RequestMethod.GET)
	    public List<Opinion> getUsuarios(){
	        return (List<Opinion>) opinionRepository.findAll();
	    }

	 @PostMapping("/guardarOpinion")
		public void registrarOpinion(@RequestBody Opinion opinion){
		 opinionRepository.save(opinion);
		}


	 @RequestMapping(path="/getOpinionesOrdenadas", method=RequestMethod.GET)
		public List<Opinion>getPreguntasResuestas(){
		return opinionRepository.findByOrderByPuntuacionDesc();
	}
}
