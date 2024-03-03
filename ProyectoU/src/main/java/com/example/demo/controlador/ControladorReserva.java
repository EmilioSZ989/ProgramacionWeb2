package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.ListaDisponibilidad;
import com.example.demo.modelo.Reserva;
import com.example.demo.repositorio.*;

@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControladorReserva {

	@Autowired
	private repositorioReserva repositorioReserva;
	@Autowired
	private repositorioListaDisponibilidad repositorioListaDisponibilidad;

	@PostMapping("/consultar_reserva")
	public List<Reserva> consultarReservaUsuario(@RequestBody Long cedula) {
		return repositorioReserva.reservasPorCedula(cedula);
	}

	@PostMapping("/cancelar_reserva")
	public Optional<Reserva> cancelarReservaUsuario(@RequestBody Long id_reserva) {
		Reserva reserva = repositorioReserva.findById(id_reserva).orElse(null);
		if (reserva != null) {
			// Obtener la lista de disponibilidad asociada a la reserva
			ListaDisponibilidad listaDisponibilidad = reserva.getId_lista_disponibilidad();
			if (listaDisponibilidad != null) {
				// Incrementar el cupo disponible en la lista de disponibilidad
				int cupoDisponible = listaDisponibilidad.getCupoDisponible();
				cupoDisponible++;
				listaDisponibilidad.setCupoDisponible(cupoDisponible);
				repositorioListaDisponibilidad.save(listaDisponibilidad);
			}
			// Eliminar la reserva
			repositorioReserva.deleteById(id_reserva);

			return Optional.of(reserva);
		} else {
			return Optional.empty();
		}
	}
}