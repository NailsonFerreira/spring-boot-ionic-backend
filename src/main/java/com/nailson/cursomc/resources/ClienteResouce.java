package com.nailson.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nailson.cursomc.domain.Cliente;
import com.nailson.cursomc.services.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResouce {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) throws ObjectNotFoundException {

		Cliente obj = service.buscar(id);

		return ResponseEntity.ok().body(obj);
	}

	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<?> inserir() {
//		
//		Categoria ct1 = new Categoria(null,"Papelaria");
//		Categoria ct2 = new Categoria(null,"Eletronicos");
//		List<Categoria> cates = new ArrayList<>();
//		cates.add(ct1);
//		cates.add(ct2);
//		
//		service.inserir(cates);
//		return ResponseEntity.ok().body(cates);
//	}

}
