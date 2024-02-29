package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Bus;

@Repository
public interface repositorioBus extends JpaRepository<Bus, Long>{
    @Query(value="SELECT b.cupo_asientos " +  // Asegúrate de agregar espacios al final de cada línea
            "FROM lista_disponibilidad ld " +
            "JOIN buses b ON ld.id_automovil = b.id_bus " +
            "WHERE ld.id_lista_disponibilidad = :idListaDisponibilidad", nativeQuery=true)
    public int buscarPorCupoAsientos(@Param("idListaDisponibilidad") Long idListaDisponibilidad);
}

