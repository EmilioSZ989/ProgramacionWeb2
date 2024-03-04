package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.*;
import com.example.demo.repositorio.*;

@RestController
@RequestMapping("/lista_disponibilidad")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControladorListaDisponibilidad {
	@Autowired
	private repositorioListaDisponibilidad repositorioListaDisponibilidad; 
	
	@GetMapping("/viajes")
	public List<ListaDisponibilidad> verTodosViajes(){
		return repositorioListaDisponibilidad.findAll();
	}
	
	@GetMapping("/ObtenerDestinoFecha")
	public List<Object[]> obtenerDestinoFecha(){
		return repositorioListaDisponibilidad.obtenerDestinoFecha();
	}
	
	@GetMapping("/listar_disponibilidad/{destino}/{fecha}")
	public List<ListaDisponibilidad> ListarPorDestinoFecha(@PathVariable String destino, @PathVariable String fecha){
		return repositorioListaDisponibilidad.listarPorDestinoFecha(destino, fecha);
	}
	
}
