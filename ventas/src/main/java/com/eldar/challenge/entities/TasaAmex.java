package com.eldar.challenge.entities;

import java.time.LocalDate;

public class TasaAmex extends TasaDecorator {
	Credito credito;
	
	public TasaAmex(Credito credito) {
		this.credito = credito;
	}
	
	@Override
	public String getDescripcion() {
		return credito.getDescripcion() + ", Tasa Amex";
	}

	@Override
	public double calcularTasa() {
		return LocalDate.now().getDayOfMonth() * 0.5 + credito.calcularTasa();
	}
}
