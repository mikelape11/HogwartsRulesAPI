package com.hogwartsRules.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Ranking")
public class Ranking {
	
	@Id
	private String _id;
	private String usuario;
	private String avatar;
	private int puntos;
	private String casaHogwarts;
	
	public Ranking(String _id, String usuario, String avatar, int puntos, String casaHogwarts) {
		super();
		this._id = _id;
		this.usuario = usuario;
		this.avatar = avatar;
		this.puntos = puntos;
		this.casaHogwarts = casaHogwarts;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getCasaHogwarts() {
		return casaHogwarts;
	}

	public void setCasaHogwarts(String casaHogwarts) {
		this.casaHogwarts = casaHogwarts;
	}

	
	
	


}
