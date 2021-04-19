package com.hogwartsRules.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
	
	 @RequestMapping(path="/editProducts", method=RequestMethod.POST)
	 public void editarTest(@RequestBody(required=false) Productos producto){
		 Query query = new Query(Criteria.where("_id").is(producto.get_id()));
		 Update update2 = new Update().set("nombre",producto.getNombre()).set("cantidad", producto.getCantidad()).set("precio", producto.getPrecio()).set("casa",producto.getPrecio()).set("tipo", producto.getTipo()).set("foto", producto.getFoto());
		 mongoTemplate.updateMulti(query, update2,Productos.class);
	 }
	 @RequestMapping(path="/eliminarProducts", method=RequestMethod.DELETE)
	 public void eliminarTest(@RequestBody(required=false) Productos id) {
		 productosRepository.deleteById(id.get_id());
	 }
}
