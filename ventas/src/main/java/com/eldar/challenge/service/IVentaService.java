package com.eldar.challenge.service;

import com.eldar.challenge.dto.VentaTcDTO;
import com.eldar.challenge.entities.Venta;
import com.eldar.challenge.exceptions.BusinessException;

public interface IVentaService {
	void validarOperacion(Venta venta) throws BusinessException;
	double getTasaByMarca(String marcaTarjeta) throws BusinessException;
	Venta RegistrarVentaConTarjeta(VentaTcDTO ventaTcDTO) throws BusinessException;
}
