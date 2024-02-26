package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Usuario;

public interface repositorioUsuario extends JpaRepository<Usuario,Long>{
	@Query(value = "SELECT * FROM reservas WHERE id_usuario = :idUsuario", nativeQuery = true)
    public List<Object> reservasPorUsuario(@Param("idUsuario") Long idUsuario);
}
