package com.exemplodev.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exemplodev.models.Cabrom;
import com.exemplodev.repositorys.RepositoryCabrom;

@Controller
@RequestMapping(value="/app")
@CrossOrigin(origins = "o domain do angular js vem aqui")
public class CabromController {
	
	@Autowired
	private RepositoryCabrom repo;//estou injetando o repository pra poder usa-lo aqui
	
	@RequestMapping(value="/inserir", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Cabrom inseriNoBanco(){
		Cabrom c = new Cabrom(null, "Sei la");//estou add esse obj
		this.repo.save(c);
		return c;
	}
	
	@RequestMapping(value="/cabrom/{codigo}")
	public HttpEntity<Cabrom> visualizar(@PathVariable("codigo") Long codigo){
		Cabrom c = this.repo.findOne(codigo);
		c.add(linkTo(methodOn(CabromController.class).visualizar(codigo)).withSelfRel());
		return new ResponseEntity<Cabrom>(c,HttpStatus.OK);
	}
}
