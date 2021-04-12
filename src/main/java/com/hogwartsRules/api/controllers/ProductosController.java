package com.hogwartsRules.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.models.Productos;
import com.hogwartsRules.api.repositories.ProductosRepository;

@RestController
@CrossOrigin(origins = "*")
public class ProductosController {
	@Autowired
	private ProductosRepository ProductosRepository;
	
	@Autowired
	protected MongoTemplate mongoTemplate;
	
	
	@RequestMapping(path="/addProduct", method=RequestMethod.POST)
	public void addProduct(@RequestBody(required=false) Productos producto){
		ProductosRepository.save(producto);
	}
}
