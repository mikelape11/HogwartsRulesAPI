package com.hogwartsRules.api.models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Carrito")
public class Carrito {

	@Id
	private String _id;
	private String idUsuario;
	private ArrayList<Productos> productos;

	public Carrito(){
	}

	public Carrito(String _id, String idUsuario, ArrayList<Productos> productos) {
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

	public ArrayList<Productos> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Productos> productos) {
		this.productos = productos;
	}


}
