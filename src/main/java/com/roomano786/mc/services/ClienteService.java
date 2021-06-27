package com.roomano786.mc.services;

import com.roomano786.mc.domain.Cliente;
import com.roomano786.mc.repositories.ClienteRepository;
import com.roomano786.mc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrado! Id: " + id + "; Tipo: " + Cliente.class.getName()
		));
	}
}
