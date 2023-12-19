package org.nasa.spring.controller;

import org.nasa.spring.entities.Reserva;
import org.nasa.spring.repository.ClienteRepository;
import org.nasa.spring.repository.DestinoRepository;
import org.nasa.spring.repository.PromocaoRepository;
import org.nasa.spring.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired
	private ReservaRepository reservaRepository; 
	@Autowired
	private ClienteRepository clienteRepository; 
	@Autowired 
	private PromocaoRepository promocaoRepository;
	@Autowired 
	private DestinoRepository destinoRepository;
	
	@GetMapping
	public ModelAndView compras() {
		ModelAndView modelAndView = new ModelAndView("views/reserva/index.html");

		modelAndView.addObject("listCli", clienteRepository.findAll());
		modelAndView.addObject("listPromo", promocaoRepository.findAll());
		modelAndView.addObject("listDest", destinoRepository.findAll());
		modelAndView.addObject("reservas", reservaRepository.findAll());
		modelAndView.addObject("reserva", new Reserva());

		return modelAndView;
	}
	
}
