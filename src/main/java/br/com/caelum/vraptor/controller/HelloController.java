package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class HelloController {

	private static final String HELLO_WORLD = "Hello, World!";
	
	@Inject private Result result;

	@Get("/json")
	public void json(){
		result.use(Results.json())
			.withoutRoot()
			.from(new Message(HELLO_WORLD))
			.serialize();
	}
	
	
	@Get("/plaintext")
	public void plaintext() {
		result.use(Results.http())
			.addHeader("Content-Type", "text/plain")
			.addHeader("charset", "UTF-8")
			.body(HELLO_WORLD);
	}
}