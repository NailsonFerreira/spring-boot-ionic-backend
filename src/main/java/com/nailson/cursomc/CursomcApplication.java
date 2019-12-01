package com.nailson.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nailson.cursomc.domain.Categoria;
import com.nailson.cursomc.domain.Cidade;
import com.nailson.cursomc.domain.Cliente;
import com.nailson.cursomc.domain.Endereco;
import com.nailson.cursomc.domain.Estado;
import com.nailson.cursomc.domain.ItemPedido;
import com.nailson.cursomc.domain.Pagamento;
import com.nailson.cursomc.domain.PagamentoComBoleto;
import com.nailson.cursomc.domain.PagamentoComCartao;
import com.nailson.cursomc.domain.Pedido;
import com.nailson.cursomc.domain.Produto;
import com.nailson.cursomc.domain.enums.EstadoPagamento;
import com.nailson.cursomc.domain.enums.TipoCliente;
import com.nailson.cursomc.repositories.CategoriaRepository;
import com.nailson.cursomc.repositories.CidadeRepository;
import com.nailson.cursomc.repositories.ClienteRepository;
import com.nailson.cursomc.repositories.EnderecoRepository;
import com.nailson.cursomc.repositories.EstadoRepository;
import com.nailson.cursomc.repositories.ItemPedidoRepository;
import com.nailson.cursomc.repositories.PagamentoRepository;
import com.nailson.cursomc.repositories.ProdutoRepository;
import com.nailson.cursomc.repositories.PedidoRepository;


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepos;
	
	@Autowired
	ProdutoRepository produtoRepos;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired 
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 300.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepos.saveAll(Arrays.asList(cat1, cat2));
		produtoRepos.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "Alagoas");
		
		Cidade cid1 = new Cidade(null, "São José", est1);
		Cidade cid2 = new Cidade(null, "Barreiros", est1);
		Cidade cid3 = new Cidade(null, "Maragogi", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		Cliente cli1 = new Cliente(null, "Maria da Silva", "maria@gmail.com", "123.456.789-00", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("8888-8888", "9999-9999"));
		
		Endereco e1 = new Endereco(null, "Rua das Flores", "123", "Casa", "Centro", "555555-555", cli1, cid1 );
		Endereco e2 = new Endereco(null, "Rua das Rosas", "456", "Apto", "Centro", "555555-555", cli1, cid2 );
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido pedi1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido pedi2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedi1, 6);
		pedi1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedi2, sdf.parse("20/10/2017 00:00"), null);
		pedi2.setPagamento(pagto2);
		
		cli1.setPedidos(Arrays.asList(pedi1, pedi2));
		
		pedidoRepository.saveAll(Arrays.asList(pedi1, pedi2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(pedi1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(pedi1, p3, 0.00, 1, 80.00);
		ItemPedido ip3 = new ItemPedido(pedi2, p2, 100.00, 1, 800.00);
	
		pedi1.getItens().addAll(Arrays.asList(ip1, ip2));
		pedi2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}
