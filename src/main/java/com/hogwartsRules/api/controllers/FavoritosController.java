package com.hogwartsRules.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	private ProductosRepository productosRepository;

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


	 @RequestMapping(path="/todosFavoritos/{usuario}", method=RequestMethod.GET)
	    public List<Favoritos> getFavoritos(@PathVariable String usuario){
	        return favoritosRepository.findByIdUsuario(usuario);
	 }

	 @PutMapping("/actualizarFavoritos")//Funcion para que un usuario desde el movil actualice sus datos
		public void actualizarFavoritos(@RequestBody Favoritos favs) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(favs.get_id()));
	    	 Favoritos fav1 = mongoTemplate.findOne(query, Favoritos.class);
	    	 fav1.setProductos(favs.getProductos());
	    	 favoritosRepository.save(fav1);
	   }



	 @PutMapping("/eliminarProductoFav")
		public void eliminarProductoFav(@RequestBody Favoritos fav) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(fav.get_id()));
	    	 Favoritos fav1 = mongoTemplate.findOne(query, Favoritos.class);
	    	 Update update = new Update().pull("productos",fav.getProductos().get(0));

	    	 mongoTemplate.findAndModify(query, update, Favoritos.class);

	   }


}
