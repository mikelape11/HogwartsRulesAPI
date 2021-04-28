package com.hogwartsRules.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.models.Carrito;
import com.hogwartsRules.api.models.Favoritos;
import com.hogwartsRules.api.models.Productos;
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
	
	@RequestMapping(path="/todosCarrito/{usuario}", method=RequestMethod.GET)
    public List<Carrito> getCarrito(@PathVariable String usuario){
        return caritoRepository.findByIdUsuario(usuario);
 }

	 @PutMapping("/actualizarCarrito")
		public void actualizarCarrito(@RequestBody Carrito carrito) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(carrito.get_id()));
	    	 Carrito carrito1 = mongoTemplate.findOne(query, Carrito.class);
	    	 carrito1.setProductos(carrito.getProductos());
	    	 caritoRepository.save(carrito1);
	   }
	
	
	
	 @PutMapping("/eliminarCarrito")
		public void eliminarCarrito(@RequestBody Carrito carrito) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(carrito.get_id()));
	    	 Carrito carrito1 = mongoTemplate.findOne(query, Carrito.class);
	    	 Update update = new Update().pull("productos",carrito.getProductos().get(0));
	
	    	 mongoTemplate.findAndModify(query, update, Carrito.class);
	
	   }


}
