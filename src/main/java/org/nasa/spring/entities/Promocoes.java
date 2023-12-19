package org.nasa.spring.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "promocoes")
public class Promocoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private double precoPromo;
    
    @DateTimeFormat(iso = ISO.DATE)
	private LocalDate validade;

	
}
