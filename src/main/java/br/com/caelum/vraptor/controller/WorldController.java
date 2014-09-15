package br.com.caelum.vraptor.controller;

import java.util.Random;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class WorldController {

	@Inject private Result result;
	@PersistenceContext private EntityManager em;
	
	@Get("/db")
	public void db(){
		
		World world = em.find(World.class, new Random().nextInt(10000)+1);
		
		result.use(Results.json())
			.withoutRoot()
			.from(world).serialize();
	}
}
