package com.eldar.challenge.entities;

import java.time.LocalDate;
import java.util.Objects;

import lombok.Data;

@Data
public class Tarjeta extends Credito {
	
	private String marca;
	private long numero;
	private CardHolder cardHolder;
	private LocalDate fechaVencimiento;
	
	public Tarjeta() {
		descripcion = "Tarjeta de crédito";
	}
	
	public Tarjeta(String marca, long numero, CardHolder cardHolder, LocalDate fechaVencimiento) {
		super();
		this.marca = marca;
		this.numero = numero;
		this.cardHolder = cardHolder;
		this.fechaVencimiento = fechaVencimiento;
		
	}

	@Override
	public double calcularTasa() {
		return 0;
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

