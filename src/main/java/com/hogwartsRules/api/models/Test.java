package com.hogwartsRules.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Test")
public class Test {
	@Id
	private String _id;
	private String numPregunta;
	private String pregunta;
	private String numRespuesta;
	private String respuesta;
	private String imagen;
	private String puntos;

	public Test(){

	}

	public Test(String _id, String numPregunta, String pregunta, String numRespuesta, String respuesta, String imagen, String puntos){
		super();
		this._id = _id;
		this.numPregunta = numPregunta;
		this.pregunta = pregunta;
		this.numRespuesta = numRespuesta;
		this.respuesta = respuesta;
		this.imagen = imagen;
		this.puntos = puntos;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNumPregunta() {
		return numPregunta;
	}

	public void setNumPregunta(String numPregunta) {
		this.numPregunta = numPregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getNumRespuesta() {
		return numRespuesta;
	}

	public void setNumRespuesta(String numRespuesta) {
		this.numRespuesta = numRespuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPuntos() {
		return puntos;
	}

	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}



}
