package com.example.demo.controlador;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modelo.Administrador;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.repositorioAdministrador;
import com.example.demo.repositorio.repositorioReserva;

import com.example.demo.modelo.*;
import com.example.demo.repositorio.*;

@RestController
@RequestMapping("/administrador")
public class ControladorAdministrador {
	@Autowired
	private repositorioAdministrador repositorioAdministrador;
	
	@Autowired

	private repositorioReserva repositorioReserva;
	
	@Autowired
	private repositorioListaDisponibilidad repositorioListaDisponibilidad;

	
	@Autowired
	private repositorioUsuario repositorioUsuario;

	@GetMapping("/ingresar_plataforma/{Usuario}-{contraseña}")
	public String ingresarPlataforma(@PathVariable String Usuario, @PathVariable String contraseña) {
		Administrador admin = repositorioAdministrador.findById(Long.valueOf(1)).orElse(null);
	    if (admin != null) {
	        if (admin.getNombreUsuario().equals(Usuario) && admin.getContrasenia().equals(contraseña)) {
	            return "Inicio de sesión exitoso";
	        } else {
	            return "Nombre de usuario o contraseña incorrectos";
	        }
	    } else {
	        return "Administrador no encontrado";
	    }
	}
	
	@GetMapping("/listar_reservas")
	public List<Reserva> listarReservaDia(){
	    LocalDate fechaActual = LocalDate.now();
	    return repositorioReserva.reservaPorDia(fechaActual);
	}

	@GetMapping("/listar_usuarios/{id_bus}")
	public List<Usuario> listarUsuariosPorAutomovil(@PathVariable Long id_bus) {
	    return repositorioUsuario.usuariosPorAutomovil(id_bus);
	}
	
	@GetMapping("/cancelar_reserva/{id_reserva}")
	public String cancelarReservaAdministrador(@PathVariable Long id_reserva) {
	    Reserva reserva = repositorioReserva.findById(id_reserva).orElse(null);
	    
	    if (reserva != null) {
	        repositorioReserva.deleteById(id_reserva);
	        
	        return "La reserva con ID " + id_reserva + " ha sido cancelada.";
	    } else {
	        return "No se encontró ninguna reserva con el ID " + id_reserva + ".";
	    }
	}
	
	
	@GetMapping("/registrar_pago/{idReserva}")
	public String registrarPago(@PathVariable Long idReserva) {
	    Reserva reserva = repositorioReserva.findById(idReserva).orElse(null);

	    if (reserva != null) {
	        if (reserva.getEstado().equals(false)) {
	            reserva.setEstado(true);
	            repositorioReserva.save(reserva);
	            return "Pago registrado exitosamente.";
	        } else if (reserva.getEstado().equals(true)) {
	            return "La reserva ya estaba pagada.";
	        } else {
	            return "Error en el estado de la reserva.";
	        }
	    } else {
	        return "Reserva no encontrada.";
	    }
	}
	
	@GetMapping("/realizar_reserva/{id_lista_disponibilidad}")
	public String realizarReservaAdmin(@PathVariable Long id_lista_disponibilidad) {
	    String ms;
	    // Datos de ejemplo para el usuario
	    String nombre = "cris";
	    String apellidos = "monte";
	    Long cedula = 432506543L;
	    String telefono = "3122345678";
	    Date fechaNacimiento = Date.valueOf("2002-08-17"); // Corrección en el formato de la fecha
	    
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
	        usuario = repositorioUsuario.findById(cedula).orElse(null); // Modificado para manejar el caso de que el usuario no se encuentre
	        
	        if (usuario != null) { // Verificar si se encontró el usuario
	            // Crear la reserva
	            Reserva reserva = new Reserva();
	            reserva.setNumeroPuesto(cupoDisponible); 
	            reserva.setEstado(false); 
	            reserva.setCedula(usuario); 
	            reserva.setId_lista_disponibilidad(repositorioListaDisponibilidad.findById(id_lista_disponibilidad).orElse(null)); // Modificado para manejar el caso de que la lista de disponibilidad no se encuentre
	            repositorioReserva.save(reserva);
	            
	            ms = "Su número de puesto es: " + cupoDisponible + " y tiene que pagar: " + reserva.getId_lista_disponibilidad().getTotalPagar();

	            // Decrementar el cupo disponible
	            cupoDisponible--;
	            
	            // Actualizar el cupo disponible en la lista de disponibilidad
	            repositorioListaDisponibilidad.actualizarCupoDisponible(id_lista_disponibilidad, cupoDisponible);
	            
	            return ms;
	        } else {
	            return "Error al crear la reserva: no se encontró el usuario.";
	        }
	    } else if (cupoDisponible == 0) {
	        repositorioListaDisponibilidad.deleteById(id_lista_disponibilidad);
	        return "Error al crear la reserva: no hay cupo disponible.";
	    }
	    return null;
	}
	@GetMapping("/modificar_datos/{idReserva}")
	public String modDatosReserva(@PathVariable Long idReserva) {
	    // Buscar la reserva por su ID
	    Reserva reserva = repositorioReserva.findById(idReserva).orElse(null);
	    
	    if (reserva != null) {
	        int nuevoNumeroPuesto = 50;
	        boolean nuevoEstado = false;
	        reserva.setNumeroPuesto(nuevoNumeroPuesto);
	        reserva.setEstado(nuevoEstado);
	        repositorioReserva.save(reserva);
	        
	        return "Los datos de la reserva han sido modificados exitosamente.";
	    } else {
	        return "No se encontró ninguna reserva con el ID especificado.";
	    }
	}

	
}
	

	

	
	

