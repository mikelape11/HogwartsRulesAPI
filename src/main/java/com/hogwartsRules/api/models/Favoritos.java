package com.hogwartsRules.api.models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Favoritos")
public class Favoritos {

	@Id
	private String _id;
	private String idUsuario;
	private String idProducto;

	public Favoritos(){
	}

	public Favoritos(String _id, String idUsuario, String idProducto) {
		super();
		this._id = _id;
		this.idUsuario = idUsuario;
		this.idProducto = idProducto;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


}
