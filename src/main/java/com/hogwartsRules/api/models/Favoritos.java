package com.hogwartsRules.api.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Favoritos")
public class Favoritos {

	@Id
	private String _id;
	private String idUsuario;
	private List<Productos> productos;

	public Favoritos(){
	}

	public Favoritos(String _id, String idUsuario, List<Productos> productos) {
		super();
		this._id = _id;
		this.idUsuario = idUsuario;
		this.productos = productos;
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

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}


}
