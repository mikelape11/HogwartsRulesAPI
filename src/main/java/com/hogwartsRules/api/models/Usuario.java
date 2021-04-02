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
	private String casa;

	public Usuario(){
	}

	public Usuario(String _id, String usuario, String password, String email, String casa) {
		super();
		this._id = _id;
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.casa = casa;
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

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

}
