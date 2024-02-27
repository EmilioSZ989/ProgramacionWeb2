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
@RequestMapping("/administrador")
public class ControladorAdministrador {
	@Autowired
	private repositorioAdministrador repositorioAdministrador;
	
	@Autowired
	private repositorioListaDisponibilidad repositorioListaDisponibilidad;
	
	@Autowired
	private repositorioUsuario repositorioUsuario;
	
	@Autowired
	private repositorioReserva repositorioReserva;

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
	
	/*@GetMapping("/listar_usuarios/{idAutomovil}")
	public List<Object> listarUsuariosPorAutomovil(@PathVariable Long idAutomovil) {
	    return repositorioAdministrador.usuariosPorAutomovil(idAutomovil);
	}
	
	@GetMapping("/modificar_datos/{idUsuario}")
    public String modDatosReserva(@PathVariable Long idUsuario) {
        int numeroPuesto=4;
        String estadoPago="debe";
        Reserva reserva = repositorioAdministrador.reservaPorUsuario(idUsuario);


        if (reserva != null) {

            reserva.setNumeroPuesto(numeroPuesto);
            reserva.setEstado(estadoPago);

            repositorioReserva.save(reserva);

            // Devolver un mensaje de éxito
            return "Datos de la reserva modificados correctamente.";
        } else {
            // Si no se encontró la reserva, devolver un mensaje de error
            return "No se encontró una reserva asociada al usuario.";
        }
    }



	@GetMapping("/registrar_pago/{idReserva}")
	public String registrarPago(@PathVariable Long idReserva) {
	    Reserva reserva = repositorioReserva.findById(idReserva).orElse(null);

	    if (reserva != null) {
	        if (reserva.getEstado().equals("debe")) {
	            reserva.setEstado("Pago");
	            repositorioReserva.save(reserva);
	            return "Pago registrado exitosamente.";
	        } else if (reserva.getEstado().equals("pago")) {
	            return "La reserva ya estaba pagada.";
	        } else {
	            return "Error en el estado de la reserva.";
	        }
	    } else {
	        return "Reserva no encontrada.";
	    }
	}

	@GetMapping("/realizar_reserva_usuario")
	public String realizarReservaUsuario() {
		return null;
		
	}*/
	
	
	
}
