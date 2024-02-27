package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Usuario;

public interface repositorioUsuario extends JpaRepository<Usuario,Long>{
	
	@Query(value = "SELECT u.* " +
            "FROM usuarios u " +
            "JOIN reservas r ON u.cedula = r.cedula " +
            "JOIN lista_disponibilidad v ON r.id_lista_disponibilidad = v.id_lista_disponibilidad " +
            "JOIN buses a ON v.id_automovil = a.id_bus " +
            "WHERE a.id_bus = :idAutomovil", 
    nativeQuery = true)
	public List<Usuario> usuariosPorAutomovil(@Param("idAutomovil") Long idAutomovil);

	
	/*@Query(value = "SELECT * FROM reservas WHERE id_usuario = :idUsuario", nativeQuery = true)
    public List<Object> reservasPorUsuario(@Param("idUsuario") Long idUsuario);*/
}
