package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class HelloController {

	@Inject private Result result;

	@Get("/json")
	public void json(){
		result.use(Results.json())
			.withoutRoot()
			.from(new Message("Hello, World!"))
			.serialize();
	}
}