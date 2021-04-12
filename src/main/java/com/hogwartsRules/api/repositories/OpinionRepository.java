package com.hogwartsRules.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hogwartsRules.api.models.Opinion;
import com.hogwartsRules.api.models.Test;

public interface OpinionRepository extends MongoRepository<Opinion, String>{

	List<Opinion> findByOrderByPuntuacionDesc();

}
