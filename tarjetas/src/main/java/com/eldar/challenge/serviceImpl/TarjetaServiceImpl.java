package com.eldar.challenge.serviceImpl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.eldar.challenge.entities.Tarjeta;
import com.eldar.challenge.exceptions.BusinessException;
import com.eldar.challenge.service.ITarjetaService;
import com.eldar.challenge.utils.ServicioExternoFinanciero;

@Service
public class TarjetaServiceImpl implements ITarjetaService {

//	@Autowired
//	ITarjetaRepository tarjetaRepository;
	
	@Override
	public boolean esLaMismaTarjeta(Tarjeta tarjeta1, Tarjeta tarjeta2) {
		return tarjeta1.equals(tarjeta2);
	}

	@Override
	public Tarjeta getTarjetaInfo(long nroTarjeta) {
			return ServicioExternoFinanciero.tarjetasMock().get(nroTarjeta);
	}
	
	@Override
	public void validarTarjeta(Tarjeta tarjeta) throws BusinessException {
		if(tarjeta.getFechaVencimiento().compareTo(LocalDate.now()) < 0) {
			throw new BusinessException("Tarjeta inválida");
		}
	}
}
