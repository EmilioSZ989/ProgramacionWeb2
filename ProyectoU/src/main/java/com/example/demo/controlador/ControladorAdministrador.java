package com.example.demo.controlador;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@CrossOrigin(origins = "http://localhost:4200/")
public class ControladorAdministrador {
	@Autowired
	private repositorioAdministrador repositorioAdministrador;

	@Autowired

	private repositorioReserva repositorioReserva;

	@Autowired
	private repositorioBus repositorioBus;

	@Autowired
	private repositorioUsuario repositorioUsuario;

	@PostMapping("/ingresar_plataforma")
	public boolean ingresarPlataforma(@RequestBody List<String> credencialesUsuario) {
	    Administrador admin = repositorioAdministrador.findById(Long.valueOf(1)).orElse(null);
	    if (admin != null) {
	        return admin.getNombreUsuario().equals(credencialesUsuario.get(0)) && admin.getContrasenia().equals(credencialesUsuario.get(1));
	    } else {
	        return false; // Si el administrador no es encontrado, se devuelve false
	    }
	}


	

	@GetMapping("/listar_usuarios/{id_bus}")
	public List<Usuario> listarUsuariosPorAutomovil(@PathVariable Long id_bus) {
		return repositorioUsuario.usuariosPorAutomovil(id_bus);
	}

	@PostMapping("/registrar_pago")
	public boolean registrarPago(@RequestBody Long idReserva) {
	    Reserva reserva = repositorioReserva.findById(idReserva).orElse(null);

	    if (reserva != null) {
	        if (!reserva.getEstado()) {
	            reserva.setEstado(true);
	            repositorioReserva.save(reserva);
	            return true; // Pago registrado exitosamente
	        } else {
	            return false; // La reserva ya estaba pagada
	        }
	    } else {
	        return false; // Reserva no encontrada
	    }
	}

	@PostMapping("/modificar_datos")
	public boolean modificarDatosReserva(@RequestBody Reserva reserva) {
	    if (reserva != null) {
	        Long idReserva = reserva.getIdReserva();
	        
	        // Buscar la reserva por su ID
	        Reserva reservaExistente = repositorioReserva.findById(idReserva).orElse(null);

	        if (reservaExistente != null) {
	            Long idListaDisponibilidad = reservaExistente.getId_lista_disponibilidad().getIdListaDisponibilidad();

	            // Obtener la lista de reservas asociadas a la lista de disponibilidad desde la base de datos
	            List<Reserva> reservas = repositorioReserva.reservasPorListaDisponibilidad(idListaDisponibilidad);

	            if (!reservas.isEmpty()) {
	                // Buscar el cupo de asientos que tiene la buseta
	                int cupoAsientos = repositorioBus.buscarPorCupoAsientos(idListaDisponibilidad);

	                // Asignar el próximo número de puesto disponible
	                int nuevoNumeroPuesto = repositorioReserva.asignarNumeroPuestoDisponible(reservas, cupoAsientos);

	                // Verificar si se encontró un puesto disponible
	                if (nuevoNumeroPuesto != -1) {
	                    // Modificar los datos de la reserva
	                    boolean nuevoEstado = reserva.getEstado(); // Podrías definir aquí el nuevo estado
	                    reservaExistente.setNumeroPuesto(nuevoNumeroPuesto);
	                    reservaExistente.setEstado(nuevoEstado);
	                    repositorioReserva.save(reservaExistente);

	                    // Retornar true para indicar que la actualización fue exitosa
	                    return true;
	                } else {
	                    throw new IllegalArgumentException("No hay asientos disponibles para modificar la reserva.");
	                }
	            } else {
	                throw new IllegalArgumentException("La reserva no tiene una lista de disponibilidad asociada.");
	            }
	        } else {
	            throw new IllegalArgumentException("Reserva no encontrada.");
	        }
	    } else {
	        throw new IllegalArgumentException("La reserva enviada es nula.");
	    }
	}



}
