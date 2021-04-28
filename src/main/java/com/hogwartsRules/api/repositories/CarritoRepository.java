package com.hogwartsRules.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Carrito;
import com.hogwartsRules.api.models.Favoritos;

public interface CarritoRepository extends MongoRepository<Carrito, String>{

	List<Carrito> findByIdUsuario(String usuario);

}
