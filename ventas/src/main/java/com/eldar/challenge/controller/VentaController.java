package com.eldar.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eldar.challenge.dto.VentaTcDTO;
import com.eldar.challenge.entities.Venta;
import com.eldar.challenge.exceptions.BusinessException;
import com.eldar.challenge.service.IVentaService;

@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	IVentaService ventaService;
	
	@PostMapping("/obtenerTasa")
	public ResponseEntity<Object> getTasa(@RequestBody Venta venta) {
		try {
			return ResponseEntity.ok(ventaService.getTasaByMarca(venta.getMarcaTarjeta()));
		} catch (BusinessException be) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(be.getMessage());
		}
	}
	
	@PostMapping("/registrarVenta")
	public ResponseEntity<String> registrarVentaConTarjeta(@RequestBody VentaTcDTO ventaTcDTO){
		try {
			ventaService.RegistrarVentaConTarjeta(ventaTcDTO);
			return ResponseEntity.ok("Venta registrada!");
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
