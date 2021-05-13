package com.hogwartsRules.api.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rules")
public class Rules {

	@Id
	private String _id;
	private String usuario;
	private String avatar;
	private int rol;
	private String rule;
	private ArrayList<Object> foto;
	private ArrayList<Object> comentarios;
	private ArrayList<Object> favoritos;
	
	public Rules(String _id, String usuario, String avatar, int rol, String rule, ArrayList<Object> foto,
			ArrayList<Object> comentarios, ArrayList<Object> favoritos) {
		super();
		this._id = _id;
		this.usuario = usuario;
		this.avatar = avatar;
		this.rol = rol;
		this.rule = rule;
		this.foto = foto;
		this.comentarios = comentarios;
		this.favoritos = favoritos;
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
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public ArrayList<Object> getFoto() {
		return foto;
	}
	public void setFoto(ArrayList<Object> foto) {
		this.foto = foto;
	}
	public ArrayList<Object> getComentarios() {
		return comentarios;
	}
	public void setComentarios(ArrayList<Object> comentarios) {
		this.comentarios = comentarios;
	}
	public ArrayList<Object> getFavoritos() {
		return favoritos;
	}
	public void setFavoritos(ArrayList<Object> favoritos) {
		this.favoritos = favoritos;
	}
	
	
	
	
	
}
