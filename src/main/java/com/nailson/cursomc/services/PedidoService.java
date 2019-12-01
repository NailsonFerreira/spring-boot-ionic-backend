package com.nailson.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nailson.cursomc.domain.Pedido;
import com.nailson.cursomc.repositories.PedidoRepository;
import com.nailson.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	public Pedido buscar(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrada!"));
	}
	
	public void inserir(List<Pedido> categoria) {
		repo.saveAll(categoria);
	}
	
}
