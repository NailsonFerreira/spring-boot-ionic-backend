package com.nailson.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nailson.cursomc.domain.Cliente;
import com.nailson.cursomc.repositories.ClienteRepository;
import com.nailson.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;
	
	public Cliente buscar(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!"));
	}
	
	public void inserir(List<Cliente> cliente) {
		repo.saveAll(cliente);
	}
	
}
