package com.eldar.challenge.entities;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TasaVisa extends TasaDecorator {
	Credito credito;
	public TasaVisa() {}
	
	public TasaVisa(Credito credito) {
		this.credito = credito;
	}
	
	@Override
	public String getDescripcion() {
		return credito.getDescripcion() + ", Tasa visa";
	}

	@Override
	public double calcularTasa() {
		return LocalDate.now().getYear()%100/LocalDate.now().getMonthValue() + credito.calcularTasa();
	}
}
