package com.example.demo.controlador;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping("/guardarUsuarios")
    public ResponseEntity<Usuario> guardarUsuarios(@RequestBody Usuario usuario) {
        Usuario usuarioGuardado = repositorioUsuario.save(usuario);
        return ResponseEntity.ok().body(usuarioGuardado);
    }
	
	@PostMapping("/realizarReserva")
    public ResponseEntity<Reserva> realizarReserva(@RequestBody List<Long> foranikey) {
        // Verificamos si se proporcionaron los datos adecuados
        if (foranikey == null || foranikey.size() != 2) {
            return ResponseEntity.badRequest().build();
        }

        // Extraemos los datos de la lista
        Long cedula = foranikey.get(0);
        Long idListaDisponibilidad = foranikey.get(1);

        // Verificamos si el usuario y el viaje existen
        Usuario usuario = repositorioUsuario.findById(cedula).orElse(null);
        ListaDisponibilidad listaDisponibilidad = repositorioListaDisponibilidad.findById(idListaDisponibilidad).orElse(null);
        if (usuario == null || listaDisponibilidad == null) {
            return ResponseEntity.notFound().build();
        }

        // Verificamos el cupo disponible en la lista de disponibilidad
        int cupoDisponible = listaDisponibilidad.getCupoDisponible();
        if (cupoDisponible <= 0) {
            return ResponseEntity.badRequest().body(new Reserva());
        }

        // Verificamos el cupo de asientos disponibles en el bus
        int cupoAsientos = repositorioBus.buscarPorCupoAsientos(idListaDisponibilidad);
        if (cupoAsientos <= 0) {
            return ResponseEntity.badRequest().body(new Reserva());
        }

        // Asignamos el próximo número de puesto disponible
        List<Reserva> reservas = repositorioReserva.reservasPorListaDisponibilidad(idListaDisponibilidad);
        int numeroPuesto = repositorioReserva.asignarNumeroPuestoDisponible(reservas, cupoAsientos);
        if (numeroPuesto == -1) {
            return ResponseEntity.badRequest().body(new Reserva());
        }

        // Creamos la reserva
        Reserva reserva = new Reserva(numeroPuesto, false, usuario, listaDisponibilidad);

        // Guardamos la reserva en la base de datos
        Reserva reservaGuardada = repositorioReserva.save(reserva);

        // Actualizamos el cupo disponible en la lista de disponibilidad
        listaDisponibilidad.setCupoDisponible(cupoDisponible - 1);
        repositorioListaDisponibilidad.save(listaDisponibilidad);

        // Retornamos la reserva guardada
        return ResponseEntity.ok().body(reservaGuardada);
    }

    
}



