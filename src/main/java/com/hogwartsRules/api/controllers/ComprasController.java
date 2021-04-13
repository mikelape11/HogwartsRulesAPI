package com.hogwartsRules.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hogwartsRules.api.models.Compras;
import com.hogwartsRules.api.repositories.ComprasRepository;

public class ComprasController {

	@Autowired
	private ComprasRepository comprasRepository;


	@Autowired
	protected MongoTemplate mongoTemplate;


	@PostMapping("/registrarCompra")
	public void registrarCompra(@RequestBody Compras compra){
		comprasRepository.save(compra);
	}
}
