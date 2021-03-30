package com.hogwartsRules.api.models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Test")
public class Test {
	@Id
	private String _id;
	private int numPregunta;
	private String pregunta;
	private ArrayList<Object> respuestas;

	public Test(){

	}

	public Test(String _id, int numPregunta, String pregunta, String numRespuesta, ArrayList<Object> respuestas){
		super();
		this._id = _id;
		this.numPregunta = numPregunta;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getNumPregunta() {
		return numPregunta;
	}

	public void setNumPregunta(int numPregunta) {
		this.numPregunta = numPregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public ArrayList<Object> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<Object> respuestas) {
		this.respuestas = respuestas;
	}





}
