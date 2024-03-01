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
public interface repositorioReserva extends JpaRepository<Reserva,Long>{
	
	@Query(value = "SELECT r.*, ld.destino, ld.fecha, ld.hora_salida, ld.total_pagar " +
	        "FROM reservas r " +
	        "JOIN lista_disponibilidad ld ON r.id_lista_disponibilidad = ld.id_lista_disponibilidad " +
	        "WHERE r.cedula = :cedula", nativeQuery = true)
	public List<Object[]> reservasPorUsuario(@Param("cedula") Long cedula);


	@Query(value = "SELECT * FROM reservas WHERE fecha_reserva = :fechaReserva", nativeQuery = true)
	public List<Reserva> reservaPorDia(@Param("fechaReserva") LocalDate fechaReserva);
	
	@Query(value = "SELECT * FROM reservas WHERE id_lista_disponibilidad = :id_lista_disponibilidad", nativeQuery = true)
	public List<Reserva> reservasPorListaDisponibilidad(@Param("id_lista_disponibilidad") Long id_lista_disponibilidad);

	public default   int asignarNumeroPuestoDisponible(List<Reserva> reservas, int cupoAsientos) {
	    boolean[] asientosDisponibles = new boolean[cupoAsientos + 1];

	    // Inicializar el array de asientos disponibles
	    for (int i = 1; i <= cupoAsientos; i++) {
	        asientosDisponibles[i] = true;
	    }

	    // Marcar los asientos ocupados por reservas existentes
	    for (Reserva reserva : reservas) {
	        if (reserva.getNumeroPuesto() > 0 && reserva.getNumeroPuesto() <= cupoAsientos) {
	            asientosDisponibles[reserva.getNumeroPuesto()] = false;
	        }
	    }

	    // Encontrar el próximo asiento disponible
	    for (int i = 1; i <= cupoAsientos; i++) {
	        if (asientosDisponibles[i]) {
	            return i;
	        }
	    }

	    // Si no hay asientos disponibles
	    return -1;
	}
}
