package com.nailson.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nailson.cursomc.domain.Categoria;
import com.nailson.cursomc.domain.Cidade;
import com.nailson.cursomc.domain.Estado;
import com.nailson.cursomc.domain.Produto;
import com.nailson.cursomc.repositories.CategoriaRepository;
import com.nailson.cursomc.repositories.CidadeRepository;
import com.nailson.cursomc.repositories.EstadoRepository;
import com.nailson.cursomc.repositories.ProdutoRepository;

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
		
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
	}

}
