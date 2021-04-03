package com.hogwartsRules.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Usuario;

public interface UsuarioRepository  extends MongoRepository<Usuario, String>{


	void deleteByusuario(String usuario);

	//Usuario findByUsuarioAndPassword(String usuario, String password);
}
