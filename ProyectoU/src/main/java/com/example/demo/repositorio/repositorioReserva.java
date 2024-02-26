package com.example.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Reserva;

	
	@Repository
	public interface repositorioReserva extends JpaRepository<Reserva, Long> {
	    
	}
	

