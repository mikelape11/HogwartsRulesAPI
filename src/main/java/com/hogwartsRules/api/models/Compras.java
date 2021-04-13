package com.hogwartsRules.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Compras")
public class Compras {

	@Id
	private String _id;
	private String idUsuario;
	private String idProducto;
	private int cantidad;

	public Compras(){
	}

	public Compras(String _id, String idUsuario, String idProducto, int cantidad) {
		super();
		this._id = _id;
		this.idUsuario = idUsuario;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


}
