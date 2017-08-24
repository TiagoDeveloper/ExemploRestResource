package com.exemplodev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exemplodev.models.Cabrom;
import com.exemplodev.repositorys.RepositoryCabrom;

@Controller
@RequestMapping(value="/app")
public class CabromController {
	
	@Autowired
	private RepositoryCabrom repo;
	
	@RequestMapping(value="/inserir", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Cabrom inseriNoBanco(){
		Cabrom c = new Cabrom(null, "Sei la");//estou add esse obj
		this.repo.save(c);
		return c;
	}
}
