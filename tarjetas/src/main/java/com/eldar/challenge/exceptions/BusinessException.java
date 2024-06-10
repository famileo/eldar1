package com.eldar.challenge.exceptions;

public class BusinessException extends Exception {

	private String descripcion;
	
	public BusinessException(String descripcion) {
		setDescripcion(descripcion);
	}
	
	@Override
	public String getMessage() {
		return getDescripcion();
	}
	
	private String getDescripcion() {
		return this.descripcion;
	}
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
