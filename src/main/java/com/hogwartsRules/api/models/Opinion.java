package com.hogwartsRules.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Opinion")
public class Opinion {

	@Id
	private String _id;
	private String usuario;
	private String valoracion;
	private float puntuacion;
	private String avatar;

	public Opinion(){

	}

	public Opinion(String _id, String usuario, String valoracion, float puntuacion, String avatar) {
		super();
		this._id = _id;
		this.usuario = usuario;
		this.valoracion = valoracion;
		this.puntuacion = puntuacion;
		this.avatar = avatar;
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

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

	public float getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}





}
