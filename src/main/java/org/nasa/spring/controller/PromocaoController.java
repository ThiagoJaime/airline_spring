package org.nasa.spring.controller;

import org.nasa.spring.entities.Promocoes;
import org.nasa.spring.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	@Autowired
	private PromocaoRepository promocaoRepository;
	
	@GetMapping
	public ModelAndView promocoes() {
		
		ModelAndView modelAndView = new ModelAndView("views/promocao/index.html");
		
		modelAndView.addObject("promocoes", promocaoRepository.findAll());
		modelAndView.addObject("promocao", new Promocoes());
		
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Promocoes promocao) {
		promocaoRepository.save(promocao);

		return "redirect:/promocao";
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		promocaoRepository.deleteById(id);

		return "redirect:/promocao";
	}
	
}
