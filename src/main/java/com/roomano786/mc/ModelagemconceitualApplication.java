package com.roomano786.mc;

import com.roomano786.mc.domain.Categoria;
import com.roomano786.mc.domain.Produto;
import com.roomano786.mc.repositories.CategoriaRepository;
import com.roomano786.mc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ModelagemconceitualApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ModelagemconceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");
		Categoria categoria3 = new Categoria(null, "Culinária");

		Produto produto1 = new Produto(null,"Computador", 15000.00);
		Produto produto2 = new Produto(null, "SSD", 4500.00);
		Produto produto3 = new Produto(null,"Fouet", 325.00);
		Produto produto4 = new Produto(null,"Impressora", 45000.00);

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto4));
		categoria2.getProdutos().addAll(Arrays.asList(produto4));
		categoria3.getProdutos().addAll(Arrays.asList(produto3));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1));
		produto3.getCategorias().addAll(Arrays.asList(categoria3));
		produto4.getCategorias().addAll(Arrays.asList(categoria1, categoria2));

		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2, categoria3));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4));


	}
}
