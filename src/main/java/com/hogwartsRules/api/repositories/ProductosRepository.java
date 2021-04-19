package com.hogwartsRules.api.repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Productos;
public interface ProductosRepository extends MongoRepository<Productos, String>{

	List<Productos> findByCasa(String string);

	List<Productos> findByTipo(String tipo);

	List<Productos> findByIdUsuario(String usuario);

}
