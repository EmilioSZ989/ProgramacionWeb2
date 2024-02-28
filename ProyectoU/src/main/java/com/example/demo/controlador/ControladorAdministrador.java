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
	@GetMapping("/modificar_datos/{idReserva}")
	public String modDatosReserva(@PathVariable Long idReserva) {
	    // Buscar la reserva por su ID
	    Reserva reserva = repositorioReserva.findById(idReserva).orElse(null);
	    
	    if (reserva != null) {
	        // Obtener la lista de disponibilidad asociada a la reserva
	        ListaDisponibilidad listaDisponibilidad = reserva.getId_lista_disponibilidad();
	        if (listaDisponibilidad != null) {
	            // Obtener el cupo de asientos disponibles en la lista de disponibilidad
	            int cupoAsientos = listaDisponibilidad.getCupoDisponible();
	            
	            // Obtener la lista de reservas existentes para esta lista de disponibilidad
	            List<Reserva> reservas = repositorioReserva.reservasPorListaDisponibilidad(listaDisponibilidad.getIdListaDisponibilidad());
	            
	            // Asignar el próximo número de puesto disponible
	            int nuevoNumeroPuesto = asignarNumeroPuestoDisponible(reservas, cupoAsientos);
	            
	            // Verificar si se encontró un puesto disponible
	            if (nuevoNumeroPuesto != -1) {
	                // Modificar los datos de la reserva
	                boolean nuevoEstado = true; // Podrías definir aquí el nuevo estado
	                reserva.setNumeroPuesto(nuevoNumeroPuesto);
	                reserva.setEstado(nuevoEstado);
	                repositorioReserva.save(reserva);
	                
	                return "Los datos de la reserva han sido modificados exitosamente.";
	            } else {
	                return "No hay asientos disponibles para modificar la reserva.";
	            }
	        } else {
	            return "La reserva no tiene una lista de disponibilidad asociada.";
	        }
	    } else {
	        return "No se encontró ninguna reserva con el ID especificado.";
	    }
	}

	public int asignarNumeroPuestoDisponible(List<Reserva> reservas, int cupoAsientos) {
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
	

	

	
	

