package com.nailson.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nailson.cursomc.domain.Categoria;
import com.nailson.cursomc.services.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResouce {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) throws ObjectNotFoundException {

		Categoria obj = service.buscar(id);

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
