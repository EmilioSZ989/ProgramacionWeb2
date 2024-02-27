package com.example.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Reserva;

@Repository
public interface repositorioReserva extends JpaRepository<Reserva, Long> {
		
	@Query(value = "SELECT * FROM reservas WHERE cedula = :cedula", nativeQuery = true)
	public List<Reserva> reservasPorUsuario(@Param("cedula") Long cedula);
	
}
	

