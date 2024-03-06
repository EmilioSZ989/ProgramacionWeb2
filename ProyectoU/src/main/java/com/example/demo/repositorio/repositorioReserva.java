package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Reserva;

@Repository
public interface repositorioReserva extends JpaRepository<Reserva, Long> {

	@Query(value = "SELECT * FROM reservas WHERE cedula = :cedula", nativeQuery = true)
	public List<Reserva> reservasPorCedula(@Param("cedula") Long cedula);
	/* public List<Reserva[]> findByCedula(Long cedula); */

	@Query(value = "SELECT * FROM reservas WHERE fecha_reserva = :fechaReserva", nativeQuery = true)
	public List<Reserva> reservaPorDia(@Param("fechaReserva") LocalDate fechaReserva);

	@Query(value = "SELECT * FROM reservas WHERE id_lista_disponibilidad = :id_lista_disponibilidad", nativeQuery = true)
	public List<Reserva> reservasPorListaDisponibilidad(@Param("id_lista_disponibilidad") Long id_lista_disponibilidad);

	
}
