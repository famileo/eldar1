package com.eldar.challenge.dto;

import com.eldar.challenge.entities.Tarjeta;
import com.eldar.challenge.entities.Venta;

import lombok.Data;

@Data
public class VentaTcDTO {
	private Venta venta;
	private Tarjeta tarjeta;
	
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
}
