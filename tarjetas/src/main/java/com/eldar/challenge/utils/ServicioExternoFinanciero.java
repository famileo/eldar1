package com.eldar.challenge.utils;

import java.time.LocalDate;
import java.util.HashMap;

import com.eldar.challenge.entities.CardHolder;
import com.eldar.challenge.entities.Tarjeta;

public class ServicioExternoFinanciero {
	
	/**
	 * A los fines de simplificar el ejercicio se emula la informacion que debe ser provista
	 * por un servicio de la financiera correspondiente a traves de web services donde se pueda consultar una tarjeta por id
	 * @return HashMap<Long, Tarjeta>
	 */
	public static HashMap<Long, Tarjeta> tarjetasMock() {
		HashMap<Long, Tarjeta> tarjetas = new HashMap<Long, Tarjeta>();
		tarjetas.put(222L, new Tarjeta("VISA", 222, new CardHolder("Juan Perez"), LocalDate.of(2019, 7, 15)));
		tarjetas.put(333L, new Tarjeta("VISA", 333, new CardHolder("Juan Perez"), LocalDate.of(2025, 7, 15)));
		tarjetas.put(444L, new Tarjeta("AMEX", 444, new CardHolder("Carlos Perez"), LocalDate.of(2020, 7, 15)));
		tarjetas.put(555L, new Tarjeta("NARA", 555, new CardHolder("Pedro Perez"), LocalDate.of(2026, 7, 15)));
		return tarjetas;
	}
}
