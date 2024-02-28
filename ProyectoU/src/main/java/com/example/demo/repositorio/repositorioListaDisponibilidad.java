package com.example.demo.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.ListaDisponibilidad;

import jakarta.transaction.Transactional;

public interface repositorioListaDisponibilidad extends JpaRepository<ListaDisponibilidad,Long>{
	@Query("SELECT ld FROM ListaDisponibilidad ld WHERE ld.destino = :destino AND ld.fecha = :fecha")
    public List<ListaDisponibilidad> listarPorDestinoFecha(@Param("destino") String destino, @Param("fecha") String fecha);

	@Query(value = "SELECT cupo_disponible FROM lista_disponibilidad AS ld " +
			"JOIN buses b ON ld.id_automovil = b.id_bus WHERE id_lista_disponibilidad = :idListaDisponibilidad", nativeQuery = true)
		public int buscarPorCupoDisponible(@Param("idListaDisponibilidad") Long idListaDisponibilidad);

	@Modifying
    @Transactional
    @Query(value = "UPDATE lista_disponibilidad SET cupo_disponible = :cupoDisponible WHERE id_lista_disponibilidad = :idListaDisponibilidad", nativeQuery = true)
	public int actualizarCupoDisponible(@Param("idListaDisponibilidad") Long idListaDisponibilidad, @Param("cupoDisponible") int cupoDisponible);
}
