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
	private repositorioBus repositorioBus;

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
	public List<Reserva> listarReservaDia() {
		LocalDate fechaActual = LocalDate.now();
		return repositorioReserva.reservaPorDia(fechaActual);
	}

	@GetMapping("/listar_usuarios/{id_bus}")
	public List<Usuario> listarUsuariosPorAutomovil(@PathVariable Long id_bus) {
		return repositorioUsuario.usuariosPorAutomovil(id_bus);
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
		Long id_lista_disponibilidad = reserva.getId_lista_disponibilidad().getIdListaDisponibilidad();
		// Obtener la lista de disponibilidad asociada a la reserva desde la base de
		// datos
		List<Reserva> reservas = repositorioReserva.reservasPorListaDisponibilidad(id_lista_disponibilidad);

		if (!reservas.isEmpty()) {
			// buscar el cupo de asietnos que tiene la buseta.
			int cupoAsientos = repositorioBus.buscarPorCupoAsientos(id_lista_disponibilidad);

			// Asignar el próximo número de puesto disponible
			int nuevoNumeroPuesto = repositorioReserva.asignarNumeroPuestoDisponible(reservas, cupoAsientos);

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
	}

}
