package br.com.caelum.vraptor.controller;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class FortuneController {

	@Inject private Result result;
	
	@PersistenceContext 
	private EntityManager manager;

	@Get("/fortunes")
	public void fortunes() {
		
		List<Fortune> fortunes = manager
				.createQuery("select f from Fortune f", Fortune.class)
				.getResultList();
		
		fortunes.add(new Fortune("Additional fortune added at request time."));
        Collections.sort(fortunes);
        result.include("fortunes", fortunes);
	}

}