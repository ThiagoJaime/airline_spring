package org.nasa.spring.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "Reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double valor;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate  dataIda;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataRetorno;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "destino_id")
	private Destino destino;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "promocao_id")
	private Promocoes promocao;
	
}
