package com.roomano786.mc.services;

import com.roomano786.mc.domain.Pedido;
import com.roomano786.mc.repositories.PedidoRepository;
import com.roomano786.mc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido buscar(Integer id) {
		 Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() ->new ObjectNotFoundException("Pedido não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));


	}
}
