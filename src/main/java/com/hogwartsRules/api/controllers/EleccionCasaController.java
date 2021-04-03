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

import com.hogwartsRules.api.models.EleccionCasa;
import com.hogwartsRules.api.models.Usuario;
import com.hogwartsRules.api.repositories.EleccionCasaRepository;

@RestController
@CrossOrigin(origins = "*")
public class EleccionCasaController {

	@Autowired
	private EleccionCasaRepository eleccionCasaRepository;


	@Autowired
	protected MongoTemplate mongoTemplate;

	@RequestMapping(path="/eleccionCasaTodos", method=RequestMethod.GET)
    public List<EleccionCasa> eleccionCasaTodos(){
        return (List<EleccionCasa>) eleccionCasaRepository.findAll();
    }

	@PostMapping("/registrarEleccionCasa")
	public void registrarEleccionCasa(@RequestBody EleccionCasa eleccionCasa){
		eleccionCasaRepository.save(eleccionCasa);
	}

	@PutMapping("/actualizarPuntos")
	  public void actualizarPuntos(@RequestBody EleccionCasa eleccionCasa) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(eleccionCasa.get_id()));
		EleccionCasa eleccionCasa1 = mongoTemplate.findOne(query, EleccionCasa.class);
		eleccionCasa1.set_id(eleccionCasa.get_id());
		eleccionCasaRepository.save(eleccionCasa);
	}


	 @DeleteMapping("/eliminarDatosPorNombre/{idUsuario}")//Funcion que borrará la ubicación del usuario al salir
	  public void deleteUbicacion(@PathVariable String idUsuario) {
		 eleccionCasaRepository.deleteByidUsuario(idUsuario);
	  }


}
