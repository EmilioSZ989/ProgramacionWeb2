package com.example.demo.repositorio;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Administrador;
import com.example.demo.modelo.Reserva;

@Repository
public interface repositorioAdministrador extends JpaRepository<Administrador, Long> {
	
	@Query(value="SELECT r FROM Reservas r WHERE DATE(r.fecha_reserva) = :fecha",nativeQuery=true)
    public List<Object> reservasDelDiaActual(@Param("fecha") Date fecha);

	@Query(value = "SELECT r.* FROM reservas r WHERE r.id_usuario = :idUsuario", nativeQuery = true)
    public Reserva reservaPorUsuario(@Param("idUsuario") Long idUsuario);
	

}
