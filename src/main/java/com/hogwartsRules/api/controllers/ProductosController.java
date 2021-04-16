package com.hogwartsRules.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.models.Productos;
import com.hogwartsRules.api.models.Usuario;
import com.hogwartsRules.api.repositories.ProductosRepository;

@RestController
@CrossOrigin(origins = "*")
public class ProductosController {
	@Autowired
	private ProductosRepository productosRepository;

	@Autowired
	protected MongoTemplate mongoTemplate;


	 @RequestMapping(path="/todosProductos", method=RequestMethod.GET)
	    public List<Productos> getProductos(){
	        return (List<Productos>) productosRepository.findAll();
	    }

	 @RequestMapping(path="/todosProductosCasa/{casa}", method=RequestMethod.GET)
	    public List<Productos> getProductosCasa(@PathVariable String casa){
	        return productosRepository.findByCasa(casa);
	 }

	 @RequestMapping(path="/todosProductosTipo/{tipo}", method=RequestMethod.GET)
	    public List<Productos> getProductosTipo(@PathVariable String tipo){
	        return productosRepository.findByTipo(tipo);
	 }

	@RequestMapping(path="/addProduct", method=RequestMethod.POST)
	public void addProduct(@RequestBody(required=false) Productos producto){
		System.out.println(producto.getNombre());
		productosRepository.save(producto);
	}
}
