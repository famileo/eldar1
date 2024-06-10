package com.eldar.challenge.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eldar.challenge.dto.VentaTcDTO;
import com.eldar.challenge.entities.Credito;
import com.eldar.challenge.entities.Tarjeta;
import com.eldar.challenge.entities.TasaAmex;
import com.eldar.challenge.entities.TasaNara;
import com.eldar.challenge.entities.TasaVisa;
import com.eldar.challenge.entities.Venta;
import com.eldar.challenge.exceptions.BusinessException;
import com.eldar.challenge.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	IVentaRepository ventaRepository;

	@Override
	public Venta RegistrarVentaConTarjeta(VentaTcDTO ventaTcDTO) throws BusinessException {
		restTemplate.postForEntity("http://localhost:8080/tarjeta/validarTarjeta",
						ventaTcDTO.getTarjeta(), Void.class);
		Venta venta = ventaTcDTO.getVenta();
		validarOperacion(venta);
		
		Credito credito = getCredito(venta.getMarcaTarjeta());
		venta.setTasa(credito.calcularTasa());
		venta.setMarcaTarjeta(credito.getDescripcion());
		venta.setImporte(venta.getImporte());
//		ventaRepository,save(venta);
		return venta;
		
	}
	
	@Override
	public void validarOperacion(Venta venta) throws BusinessException {
		if(venta.getImporte() > 999) {
			throw new BusinessException("La operación supera el limite permitido");
		}
	}

	@Override
	public double getTasaByMarca(String MarcaTarjeta) throws BusinessException {
		Credito credito = new Tarjeta();
		credito = getTasa(credito, MarcaTarjeta);
		return credito.calcularTasa();
	}

	private Credito getCredito(String marcaTarjeta) throws BusinessException {
		Credito credito = new Tarjeta();
		return getTasa(credito, marcaTarjeta);
	}

	// TODO evaluar implementacion del patron Visitor o Strategy para eliminar el switch
	private Credito getTasa(Credito credito, String marca) throws BusinessException{	
		switch(marca) {
		case "VISA": 
			return new TasaVisa(credito);
		case "AMEX":
			return new TasaAmex(credito);
		case "NARA":
			return new TasaNara(credito);
		default:
			throw new BusinessException("Marca de tarjeta inválida");
		}
	}
}
