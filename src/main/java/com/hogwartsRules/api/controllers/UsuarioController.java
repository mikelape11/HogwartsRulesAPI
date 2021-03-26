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
}
