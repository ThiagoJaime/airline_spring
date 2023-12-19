package org.nasa.spring.controller;

import org.nasa.spring.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.nasa.spring.entities.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ModelAndView clientes() {
		
		ModelAndView modelAndView = new ModelAndView("views/cliente/index.html");
		
		modelAndView.addObject("clientes", clienteRepository.findAll());
		modelAndView.addObject("cliente", new Cliente());
		
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		clienteRepository.save(cliente);

		return "redirect:/clientes";
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		clienteRepository.deleteById(id);

		return "redirect:/clientes";
	}
	
	
}
