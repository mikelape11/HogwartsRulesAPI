package com.hogwartsRules.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.models.Favoritos;
import com.hogwartsRules.api.models.Productos;
import com.hogwartsRules.api.models.Usuario;
import com.hogwartsRules.api.repositories.FavoritosRepository;
import com.hogwartsRules.api.repositories.ProductosRepository;

@RestController
@CrossOrigin(origins = "*")
public class FavoritosController {


	@Autowired
	private FavoritosRepository favoritosRepository;

	@Autowired
	protected MongoTemplate mongoTemplate;

	@RequestMapping(path="/todosFavoritos", method=RequestMethod.GET)
    public List<Favoritos> getFavoritos(){
        return (List<Favoritos>) favoritosRepository.findAll();
    }

	@RequestMapping(path="/addFavorito", method=RequestMethod.POST)
	public void addProduct(@RequestBody(required=false) Favoritos favorito){
		favoritosRepository.save(favorito);
	}
}
