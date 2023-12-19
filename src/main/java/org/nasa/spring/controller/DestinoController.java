package org.nasa.spring.controller;


import org.nasa.spring.entities.Destino;
import org.nasa.spring.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/destino")
public class DestinoController {
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	@GetMapping
	public ModelAndView destinos() {
		
		ModelAndView modelAndView = new ModelAndView("views/destino/index.html");
		
		modelAndView.addObject("destinos", destinoRepository.findAll());
		modelAndView.addObject("destino", new Destino());
		
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Destino destino) {
		destinoRepository.save(destino);

		return "redirect:/destino";
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		destinoRepository.deleteById(id);

		return "redirect:/destino";
	}
	
	
}
