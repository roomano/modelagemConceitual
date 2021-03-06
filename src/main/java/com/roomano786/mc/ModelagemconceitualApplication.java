package com.roomano786.mc;

import com.roomano786.mc.domain.*;
import com.roomano786.mc.domain.enums.EstadoPagamento;
import com.roomano786.mc.domain.enums.TipoCliente;
import com.roomano786.mc.repositories.*;
import org.hibernate.collection.internal.PersistentIdentifierBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class ModelagemconceitualApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

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

		Provincia provincia1 = new Provincia(null, "Maputo");
		Provincia provincia2 = new Provincia(null, "Nampula");

		Cidade cidade1 = new Cidade(null, "Matola", provincia1);
		Cidade cidade2 = new Cidade(null, "Nacala-Porto", provincia2);
		Cidade cidade3 = new Cidade(null, "Angoche", provincia2);
		Cidade cidade4 = new Cidade(null, "Maputo_Cidade",provincia1);

		provincia1.getCidades().addAll(Arrays.asList(cidade1, cidade4));
		provincia2.getCidades().addAll(Arrays.asList(cidade2, cidade3));

		provinciaRepository.saveAll(Arrays.asList(provincia1, provincia2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3, cidade4));

		Cliente cliente1 = new Cliente(null, "Romano Ivan Pedro", "romanoivanchicra@gmail.com", "78930790", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("839809878", "847198940"));

		Cliente cliente2 = new Cliente(null, "Joaquim Pereira", "joaquim@outlook.com", "890284798",
				TipoCliente.PESSOAFISICA);
		cliente2.getTelefones().addAll(Arrays.asList("872309349", "862983239"));

		Cliente cliente3 = new Cliente(null, "JVM Inc.", "jvm.contato@empresa.com", "78907238", TipoCliente.PESSOAJURIDICA);
		cliente3.getTelefones().addAll(Arrays.asList("21887086", "84234", "8208797", "868070"));

		Endereco endereco1 = new Endereco(null, "787", "12","3 de Fevereiro", "1120", cliente3, cidade1);
		Endereco endereco2 = new Endereco(null, "2345", "45", "Polana", "1110", cliente3, cidade4);

		cliente3.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));

		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido pedido1 = new Pedido(null,sdf.parse("05/05/2021 14:25"), cliente3, endereco1 );
		Pedido pedido2 = new Pedido(null, sdf.parse("28/05/2021 10:23"), cliente3, endereco2);

		Pagamento pagamento1 = new PagamentoCartao(null, EstadoPagamento.PAGO, pedido1, 6);
		pedido1.setPagamento(pagamento1);
		Pagamento pagamento2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("12/04/2021 16:25")
				, null);
		pedido2.setPagamento(pagamento2);

		cliente3.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));

		ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 0.00, 1, produto1.getPreco());
		ItemPedido itemPedido2 = new ItemPedido(pedido2, produto2, 0.00, 1, produto2.getPreco());
		pedido1.getItens().addAll(Arrays.asList(itemPedido1));
		pedido2.getItens().addAll(Arrays.asList(itemPedido2));

		produto1.getItens().addAll(Arrays.asList(itemPedido1));
		produto2.getItens().addAll(Arrays.asList(itemPedido2));

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2));






	}
}
