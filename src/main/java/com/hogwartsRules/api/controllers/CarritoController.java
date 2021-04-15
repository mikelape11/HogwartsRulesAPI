package com.hogwartsRules.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.models.Carrito;
import com.hogwartsRules.api.models.Favoritos;
import com.hogwartsRules.api.repositories.CarritoRepository;

@RestController
@CrossOrigin(origins = "*")
public class CarritoController {

	@Autowired
	private CarritoRepository caritoRepository;

	@Autowired
	protected MongoTemplate mongoTemplate;

	@RequestMapping(path="/todosCarrito", method=RequestMethod.GET)
    public List<Carrito> getFavoritos(){
        return (List<Carrito>) caritoRepository.findAll();
    }

	@RequestMapping(path="/addCarrito", method=RequestMethod.POST)
	public void addProduct(@RequestBody(required=false) Carrito carrito){
		caritoRepository.save(carrito);
	}
}
