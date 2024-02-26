package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.*;
import com.example.demo.repositorio.*;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {
	@Autowired
	private repositorioUsuario repositorioUsuario;
	
	@Autowired
	private repositorioReserva repositorioReserva;
	
	@GetMapping("/consultar_reserva/{idUsuario}")
	public List<Object> consultarReservaUsuario(@PathVariable Long idUsuario){
		return repositorioUsuario.reservasPorUsuario(idUsuario);
		
	}
	

}
