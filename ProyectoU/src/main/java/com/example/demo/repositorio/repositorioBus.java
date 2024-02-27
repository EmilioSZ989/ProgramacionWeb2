package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Bus;

public interface repositorioBus extends JpaRepository<Bus, Long>{
	/*@Query("SELECT ld.idBus.cupoAsientos FROM ListaDisponibilidad ld WHERE ld.idListaDisponibilidad = :idListaDisponibilidad")
	public int buscarPorCupoAsientos(@Param("idListaDisponibilidad") Long idListaDisponibilidad);*/



}
