package com.hogwartsRules.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EleccionCasa")
public class EleccionCasa {

	@Id
	private String _id;
	private String idUsuario;
	private int puntosGry;
	private int puntosSly;
	private int puntosHuff;
	private int puntosRav;

	public EleccionCasa(){
	}

	public EleccionCasa(String _id, String idUsuario, int puntosGry, int puntosSly, int puntosHuff, int puntosRav) {
		super();
		this._id = _id;
		this.idUsuario = idUsuario;
		this.puntosGry = puntosGry;
		this.puntosSly = puntosSly;
		this.puntosHuff = puntosHuff;
		this.puntosRav = puntosRav;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getidUsuario() {
		return idUsuario;
	}

	public void setidUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getPuntosGry() {
		return puntosGry;
	}

	public void setPuntosGry(int puntosGry) {
		this.puntosGry = puntosGry;
	}

	public int getPuntosSly() {
		return puntosSly;
	}

	public void setPuntosSly(int puntosSly) {
		this.puntosSly = puntosSly;
	}

	public int getPuntosHuff() {
		return puntosHuff;
	}

	public void setPuntosHuff(int puntosHuff) {
		this.puntosHuff = puntosHuff;
	}

	public int getPuntosRav() {
		return puntosRav;
	}

	public void setPuntosRav(int puntosRav) {
		this.puntosRav = puntosRav;
	}


}
