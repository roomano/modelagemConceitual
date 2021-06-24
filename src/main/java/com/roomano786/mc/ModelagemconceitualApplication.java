package com.roomano786.mc;

import com.roomano786.mc.domain.Categoria;
import com.roomano786.mc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ModelagemconceitualApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ModelagemconceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");
		Categoria categoria3 = new Categoria(null, "Culinária");

		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2, categoria3));


	}
}
