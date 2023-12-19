package org.nasa.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotasController {

	@GetMapping("/destinos")
	public String destinos() {
		return "destinos";
	}

	@GetMapping("/promocoes")
	public String promocoes() {
		return "promocoes";
	}

	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}

}
