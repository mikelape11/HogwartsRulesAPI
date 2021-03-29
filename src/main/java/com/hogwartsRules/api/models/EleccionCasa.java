package com.hogwartsRules.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EleccionCasa")
public class EleccionCasa {
	@Id
	private String _id;
	private String id_usuario;
	private int puntos;

	public EleccionCasa(){
	}

	public EleccionCasa(String _id, String id_usuario, int puntos) {
		super();
		this._id = _id;
		this.id_usuario = id_usuario;
		this.puntos = puntos;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}





}
