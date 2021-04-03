package com.hogwartsRules.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hogwartsRules.api.repositories.UsuarioRepository;
import com.hogwartsRules.api.models.Usuario;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

 @Autowired
    private UsuarioRepository usuarioRepository;
 @Autowired
    protected MongoTemplate mongoTemplate;

 @RequestMapping(path="/todos", method=RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

	@RequestMapping(path="/login", method=RequestMethod.POST)
	public boolean login(@RequestBody(required=false) Usuario user){

		List<Usuario> users = (List<Usuario>) usuarioRepository.findAll();

		for(Usuario p:users){
			if(p.getUsuario().equals(user.getUsuario()) && p.getPassword().equals(user.getPassword())) {

				return true;
			}
		}

		return false;
	}

	@PostMapping("/register")
	public void register(@RequestBody Usuario usuario){
		usuarioRepository.save(usuario);
	}


	 @PutMapping("/actualizarUsuario")//Funcion para que un usuario desde el movil actualice sus datos
		public void actualizarUsuario(@RequestBody Usuario usuario) {
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("_id").is(usuario.get_id()));
	    	 Usuario userTest1 = mongoTemplate.findOne(query, Usuario.class);
	    	 userTest1.setUsuario(usuario.getUsuario());
	    	 usuarioRepository.save(usuario);
	   }


	 @DeleteMapping("/eliminarPorNombre/{usuario}")//Funcion que borrará la ubicación del usuario al salir
	  public void deleteUbicacion(@PathVariable String usuario) {
		 usuarioRepository.deleteByusuario(usuario);
	  }


	 @PutMapping("/actualiziarCasaHogwarts")//Funcion para que un usuario desde el movil actualice sus datos
		public void actualiziarCasaHogwarts(@RequestBody Usuario usuario) {
    	 	 System.out.println(usuario.getUsuario());
	    	 Query query = new Query();
	    	 query.addCriteria(Criteria.where("usuario").is(usuario.getUsuario()));
	    	 Usuario userTest1 = mongoTemplate.findOne(query, Usuario.class);
	    	 userTest1.setCasaHogwarts(usuario.getCasaHogwarts());
	    	 usuarioRepository.save(userTest1);
	   }



}
