package com.hogwartsRules.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Favoritos;
import com.hogwartsRules.api.models.Productos;

public interface FavoritosRepository extends MongoRepository<Favoritos, String>{

	void deleteByIdUsuario(String usuario);

	List<Favoritos> findByIdUsuario(String usuario);

}
