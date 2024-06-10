package com.eldar.challenge.entities;

import java.time.LocalDate;

public class TasaNara extends TasaDecorator {
	Credito credito;
	
	public TasaNara(Credito credito) {
		this.credito = credito;
	}
	@Override
	public String getDescripcion() {
		return credito.getDescripcion() + ", Tasa Nara";
	}

	@Override
	public double calcularTasa() {
		return LocalDate.now().getMonthValue() * 0.1 + credito.calcularTasa();
	}

}
