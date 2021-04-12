package com.hogwartsRules.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class Usuario {
	@Id
	private String _id;
	private String usuario;
	private String password;
	private String email;
	private String casaHogwarts;
	private String varita;
	private String patronus;
	private String casa;
	private String avatar;
	private int rol;

	public Usuario(){
	}

	public Usuario(String _id, String usuario, String password, String email, String casaHogwarts, String varita, String patronus, String casa,
			String avatar, int rol) {
		this._id = _id;
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.casaHogwarts = casaHogwarts;
		this.varita = varita;
		this.patronus = patronus;
		this.casa = casa;
		this.avatar = avatar;
		this.rol = rol;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCasaHogwarts() {
		return casaHogwarts;
	}

	public void setCasaHogwarts(String casaHogwarts) {
		this.casaHogwarts = casaHogwarts;
	}

	public String getVarita() {
		return varita;
	}

	public void setVarita(String varita) {
		this.varita = varita;
	}

	public String getPatronus() {
		return patronus;
	}

	public void setPatronus(String patronus) {
		this.patronus = patronus;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}


}
