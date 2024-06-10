package com.eldar.challenge.entities;

public abstract class Credito {
	String descripcion = "";
	
	public String getDescripcion() {
		return descripcion;
	}
	public abstract double calcularTasa();
}

