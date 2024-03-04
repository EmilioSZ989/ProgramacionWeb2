package com.example.demo.controlador;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.*;
import com.example.demo.repositorio.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControladorUsuario {
	@Autowired
	private repositorioUsuario repositorioUsuario;

	@Autowired
	private repositorioReserva repositorioReserva;

	@Autowired
	private repositorioBus repositorioBus;

	@Autowired
	private repositorioListaDisponibilidad repositorioListaDisponibilidad;

	@PostMapping("/usuarios-por-bus")
	public List<Usuario> listarUsuariosPorAutomovil(@RequestBody Long id_bus) {
		return repositorioUsuario.usuariosPorAutomovil(id_bus);
	}
	
	// CORREGIR ESTE CODE
	@GetMapping("/realizar_reserva/{id_lista_disponibilidad}")
	public String realizarReserva(@PathVariable Long id_lista_disponibilidad) {
		String ms = "Error, reserva no encontrada";
		String nombre = "emi";
		String apellidos = "suaza";
		Long cedula = 123456543L;
		String telefono = "1234567890";
		Date fechaNacimiento = Date.valueOf("2004-04-08");

		int cupoDisponible = repositorioListaDisponibilidad.buscarPorCupoDisponible(id_lista_disponibilidad);

		int cupoAsientos = repositorioBus.buscarPorCupoAsientos(id_lista_disponibilidad);

		if (cupoDisponible > 0) {
			// Crear el usuario y guardarlo en la base de datos
			Usuario usuario = new Usuario(cedula, nombre, apellidos, telefono, fechaNacimiento);
			repositorioUsuario.save(usuario);

			// Obtener el usuario recién creado
			usuario = repositorioUsuario.findById(cedula).orElse(null);
			if (usuario == null) {
				return "Error al crear el usuario";
			}

			// Obtener la lista de reservas existentes para esta lista de disponibilidad
			List<Reserva> reservas = repositorioReserva.reservasPorListaDisponibilidad(id_lista_disponibilidad);

			// Asignar el próximo número de puesto disponible
			int numeroPuesto = repositorioReserva.asignarNumeroPuestoDisponible(reservas, cupoAsientos);

			if (numeroPuesto != -1) {
				// Crear la reserva y asignar el número de puesto
				Reserva reserva = new Reserva(numeroPuesto, false, usuario,
						repositorioListaDisponibilidad.findById(id_lista_disponibilidad).orElse(null));
				if (reserva.getId_lista_disponibilidad() == null) {
					return "Error al obtener la opción que seleccionaste en la lista de disponibilidad";
				}
				repositorioReserva.save(reserva);

				ms = "Su número de puesto es: " + numeroPuesto + " y tiene que pagar: "
						+ reserva.getId_lista_disponibilidad().getTotalPagar();
				cupoDisponible--;
				repositorioListaDisponibilidad.actualizarCupoDisponible(id_lista_disponibilidad, cupoDisponible);
				return ms;
			} else {
				return "No hay asientos disponibles";
			}
		} else {
			return "Ya no es posible reservar en esta lista de disponibilidad";
		}
	}

}
