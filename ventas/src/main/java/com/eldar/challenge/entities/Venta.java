package com.eldar.challenge.entities;

import lombok.Data;

@Data
public class Venta {
	private int id;
	private double importe;
	private double tasa;
	private String marcaTarjeta;
	
	public Venta() {}
	
	public Venta(double importe, String marcaTarjeta) {
		this.importe = importe;
		this.marcaTarjeta = marcaTarjeta;
	}	
	
	public Venta(int id, double importe, double tasa, String marcaTarjeta) {
		this.id = id;
		this.importe = importe;
		this.tasa = tasa;
		this.marcaTarjeta = marcaTarjeta;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getImporte() {
		return this.importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public double getTasa() {
		return this.tasa;
	}
	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
	public String getMarcaTarjeta() {
		return this.marcaTarjeta;
	}
	public void setMarcaTarjeta(String marcaTarjeta) {
		this.marcaTarjeta = marcaTarjeta;
	}
}
