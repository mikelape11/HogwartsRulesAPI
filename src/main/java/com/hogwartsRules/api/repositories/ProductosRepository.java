package com.hogwartsRules.api.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Productos;
public interface ProductosRepository extends MongoRepository<Productos, String>{

}
