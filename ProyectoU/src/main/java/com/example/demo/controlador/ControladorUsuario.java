package com.example.demo.controlador;

import java.sql.Date;
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
	
	@Autowired
	private repositorioBus repositorioBus;
	
	@Autowired
	private repositorioListaDisponibilidad repositorioListaDisponibilidad;
	
	@GetMapping("/realizar_reserva/{id_lista_disponibilidad}")
	public String realizarReserva(@PathVariable Long id_lista_disponibilidad) {
		String ms;
	    // Datos de ejemplo para el usuario
	    String nombre = "Juan";
	    String apellidos = "Pérez";
	    Long cedula = 123456789L;
	    String telefono = "1234567890";
	    Date fechaNacimiento = Date.valueOf("1990-01-01");
	    
	    
	    
	    // Obtener el cupo disponible de la lista de disponibilidad
	    int cupoDisponible = repositorioListaDisponibilidad.buscarPorCupoDisponible(id_lista_disponibilidad);
	    
	    // Verificar si hay cupo disponible
	    if (cupoDisponible > 0) {
	        // Crear y guardar el usuario
	        Usuario usuario = new Usuario();
	        usuario.setCedula(cedula);
	        usuario.setNombre(nombre);
	        usuario.setApellidos(apellidos);
	        usuario.setTelefono(telefono);
	        usuario.setFechaNacimiento(fechaNacimiento);
	        repositorioUsuario.save(usuario);
	        
	        // Obtener el usuario recién creado con su ID asignado
	        usuario = repositorioUsuario.findById(cedula).get();
	        
	        // Crear la reserva
	        Reserva reserva = new Reserva();
	        reserva.setNumeroPuesto(cupoDisponible); 
	        reserva.setEstado(false); 
	        reserva.setCedula(usuario); 
	        reserva.setId_lista_disponibilidad(repositorioListaDisponibilidad.findById(id_lista_disponibilidad).get());
	        repositorioReserva.save(reserva);
	        
	        ms = "Su número de puesto es: " + cupoDisponible + " y tiene que pagar: " + reserva.getId_lista_disponibilidad().getTotalPagar();

	        // Decrementar el cupo disponible
	        cupoDisponible--;
	        
	        // Actualizar el cupo disponible en la lista de disponibilidad
	        repositorioListaDisponibilidad.actualizarCupoDisponible(id_lista_disponibilidad, cupoDisponible);
	        
	        return ms;
	    } else if (cupoDisponible == 0) {
	    	repositorioListaDisponibilidad.deleteById(id_lista_disponibilidad);
	    }
	    return null;
	}
	
	@GetMapping("/consultar_reserva/{cedula}")
	public List<Reserva> consultarReservaUsuario(@PathVariable Long cedula){
		return repositorioReserva.reservasPorUsuario(cedula);
		
	}
	@GetMapping("/cancelar_reserva/{id_reserva}")
	public String cancelarReserva(@PathVariable Long id_reserva) {
	    Reserva reserva = repositorioReserva.findById(id_reserva).orElse(null);
	    
	    if (reserva != null) {
	        repositorioReserva.deleteById(id_reserva);
	        
	        return "La reserva con ID " + id_reserva + " ha sido cancelada.";
	    } else {
	        return "No se encontró ninguna reserva con el ID " + id_reserva + ".";
	    }
		
	}

}
