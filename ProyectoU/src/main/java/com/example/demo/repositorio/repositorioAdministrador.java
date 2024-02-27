package com.example.demo.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Administrador;
import com.example.demo.modelo.Reserva;

public interface repositorioAdministrador extends JpaRepository<Administrador, Long> {
	
	
	@Query(value = "SELECT r.* FROM reservas r WHERE r.id_usuario = :idUsuario", nativeQuery = true)
    public Reserva reservaPorUsuario(@Param("idUsuario") Long idUsuario);
	
}
