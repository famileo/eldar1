package com.eldar.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eldar.challenge.entities.CardHolder;
import com.eldar.challenge.entities.Tarjeta;

@SpringBootTest
class TarjetasApplicationTests {

	Tarjeta tarjeta1;
	Tarjeta tarjeta2;
	Tarjeta tarjeta3;
	
	@BeforeEach
	void startUp() {
		CardHolder cardHolder = new CardHolder("Juan Perez");
		LocalDate localDate = LocalDate.now();
		tarjeta1 = new Tarjeta("VISA", 4, cardHolder, localDate);
		tarjeta2 = new Tarjeta("AMEX", 5, cardHolder, localDate);
		tarjeta3 = new Tarjeta("VISA", 4, cardHolder, localDate);
	}
	
	@Test
	void sonIguales() {
		assertEquals(tarjeta1, tarjeta3);
	}
	@Test
	void sonDiferentes() {
		assertNotEquals(tarjeta1, tarjeta2);
	}
}
