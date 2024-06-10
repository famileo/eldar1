package com.eldar.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eldar.challenge.entities.Tarjeta;
import com.eldar.challenge.exceptions.BusinessException;
import com.eldar.challenge.service.ITarjetaService;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {

	@Autowired
	ITarjetaService tarjetaService;
	
	@GetMapping("/getByNumber/{number}")
	public ResponseEntity<Object> getTarjetaByNumber(@PathVariable("number") long numero){
		Tarjeta tarjeta = tarjetaService.getTarjetaInfo(numero);
		if(tarjeta == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("La información de la tarjeta no esta disponible");
		}
		return ResponseEntity.ok(tarjeta);
	}
	
	@PostMapping("/validarTarjeta")
	public ResponseEntity<String> validarTarjeta(@RequestBody Tarjeta tarjeta) {
		try {
			tarjetaService.validarTarjeta(tarjeta);
			return ResponseEntity.ok("Tarjeta válida");
		} catch (BusinessException be){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body(be.getMessage());
		}
	}
}
	
