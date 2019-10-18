package com.nailson.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nailson.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categoria")
public class CategoriaResouce {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> getTeste() {
		
		Categoria ct1 = new Categoria(1,"Informatica");
		Categoria ct2 = new Categoria(2,"Escritorio");
		List<Categoria> cates = new ArrayList<>();
		cates.add(ct1);
		cates.add(ct2);
		
		return cates;
	}

}
