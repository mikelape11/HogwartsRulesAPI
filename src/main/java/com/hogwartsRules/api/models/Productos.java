package com.hogwartsRules.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EleccionCasa")
public class Productos {
	@Id
	private String _id;
	private String nombre;
	private int cantidad;
	private int precio;
	private String casa;
	private String tipo;

	public Productos(){
	}

	public Productos(String _id, String nombre, int cantidad, int precio, String casa,String tipo) {
		super();
		this._id = _id;
		this.nombre= nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.casa = casa;
		this.tipo = tipo;
	}




}
