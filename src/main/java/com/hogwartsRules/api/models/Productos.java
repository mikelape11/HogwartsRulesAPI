package com.hogwartsRules.api.models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Productos")
public class Productos {
	@Id
	private String _id;
	private String nombre;
	private int cantidad;
	private int precio;
	private String casa;
	private String tipo;
	private float peso;
	private ArrayList<Object> foto;

	public Productos(){
	}

	public Productos(String _id, String nombre, int cantidad, int precio, String casa,String tipo,float peso,ArrayList<Object> foto) {
		this._id = _id;
		this.nombre= nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.casa = casa;
		this.tipo = tipo;
		this.peso = peso;
		this.foto = foto;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public ArrayList<Object> getFoto() {
		return foto;
	}

	public void setFoto(ArrayList<Object> foto) {
		this.foto = foto;
	}




}
