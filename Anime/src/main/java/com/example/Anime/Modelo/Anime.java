package com.example.Anime.Modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Anime {
	
	@Id
	private String id;
	private String nombre;
	private String partes;
	private String lugar;
	private String demonio;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPartes() {
		return partes;
	}
	public void setPartes(String partes) {
		this.partes = partes;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getDemonio() {
		return demonio;
	}
	public void setDemonio(String demonio) {
		this.demonio = demonio;
	}

	
}
