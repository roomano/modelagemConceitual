package com.roomano786.mc.services;

import com.roomano786.mc.domain.Categoria;
import com.roomano786.mc.repositories.CategoriaRepository;
import com.roomano786.mc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada! Id: " + id + "; Tipo: " + Categoria.class.getName()
		));
	}
}
