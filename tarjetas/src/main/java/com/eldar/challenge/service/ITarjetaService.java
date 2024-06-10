package com.eldar.challenge.service;

import com.eldar.challenge.entities.Tarjeta;
import com.eldar.challenge.exceptions.BusinessException;

public interface ITarjetaService {

	boolean esLaMismaTarjeta(Tarjeta tarjeta1, Tarjeta tarjeta2);
	Tarjeta getTarjetaInfo(long nroTarjeta);
	void validarTarjeta(Tarjeta tarjeta) throws BusinessException;
	
}
