package com.eldar.challenge.entities;

import java.time.LocalDate;
import java.util.Objects;

import lombok.Data;

@Data
public class Tarjeta {
	
	private int id;
	private String marca;
	private long numero;
	private CardHolder cardHolder;
	private LocalDate fechaVencimiento;
	
	public Tarjeta() {
	}
	
	public Tarjeta(String marca, long numero, CardHolder cardHolder, LocalDate fechaVencimiento) {
		this.marca = marca;
		this.numero = numero;
		this.cardHolder = cardHolder;
		this.fechaVencimiento = fechaVencimiento;
		
	}

	public String getMarca() {
		return this.marca;
	}
	public LocalDate getFechaVencimiento() {
		return this.fechaVencimiento;
	}
	public long getNumero() {
		return this.numero;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cardHolder, fechaVencimiento, marca, numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(cardHolder, other.cardHolder) && Objects.equals(fechaVencimiento, other.fechaVencimiento)
				&& Objects.equals(marca, other.marca) && numero == other.numero;
	}
}

