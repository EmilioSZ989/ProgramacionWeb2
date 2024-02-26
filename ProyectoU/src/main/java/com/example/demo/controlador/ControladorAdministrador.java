package com.example.demo.controlador;

import java.time.LocalDate;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.example.demo.modelo.Administrador;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.repositorioAdministrador;
import com.example.demo.repositorio.repositorioReserva;
=======
import com.example.demo.modelo.*;
import com.example.demo.repositorio.*;
>>>>>>> 005da91dca40a8e213580acd6a641be7d29c52b8
@RestController
@RequestMapping("/administrador")
public class ControladorAdministrador {
	@Autowired
	private repositorioAdministrador repositorioAdministrador;
	
	@Autowired
<<<<<<< HEAD
	private repositorioReserva repositorioReserva;
	
=======
	private repositorioViaje repositorioViaje;
	
	@Autowired
	private repositorioUsuario repositorioUsuario;
	
	@Autowired
	private repositorioReserva repositorioReserva;

>>>>>>> 005da91dca40a8e213580acd6a641be7d29c52b8
	@GetMapping("/ingresar_plataforma/{nombreUsuario}-{contraseña}")
	public String ingresarPlataforma(@PathVariable String nombreUsuario, @PathVariable String contraseña) {
		Administrador admin = repositorioAdministrador.findById(Long.valueOf(1)).orElse(null);
	    if (admin != null) {
	        if (admin.getNombreUsuario().equals(nombreUsuario) && admin.getContraseña().equals(contraseña)) {
	            return "Inicio de sesión exitoso";
	        } else {
	            return "Nombre de usuario o contraseña incorrectos";
	        }
	    } else {
	        return "Administrador no encontrado";
	    }
	}
	
	@GetMapping("/listar_usuarios/{idAutomovil}")
	public List<Object> listarUsuariosPorAutomovil(@PathVariable Long idAutomovil) {
	    return repositorioAdministrador.usuariosPorAutomovil(idAutomovil);
	}
<<<<<<< HEAD
	  
=======
	
	@GetMapping("/modificar_datos/{idReserva}")
	public Reserva modDatosReserva(@PathVariable Long idReserva) {
	    // Obtener la reserva existente por su ID
	    Reserva reserva = repositorioReserva.findById(idReserva).orElse(null);
	    
	    if (reserva != null) {
	        Usuario user = repositorioUsuario.findById(Long.valueOf(2)).orElse(null);
	        Administrador admin = repositorioAdministrador.findById(Long.valueOf(1)).orElse(null);
	        Viaje viaje = repositorioViaje.findById(Long.valueOf(3)).orElse(null);
	        
	        if (user != null && admin != null && viaje != null) {
	            // Actualizar los atributos de la reserva existente
	            reserva.setNumeroPuesto(4);
	            reserva.setEstado("Ocupado");
	            reserva.setIdUsuario(user);
	            reserva.setIdAdministrador(admin);
	            reserva.setIdViaje(viaje);
	            
	            // Guardar los cambios en la base de datos y devolver la reserva modificada
	            return repositorioReserva.save(reserva);
	        }
	    }
	    
	    return null; // Manejar el caso en el que la reserva no se encuentre o no se puedan encontrar los usuarios/administrador/viaje
	}



	
	
	
	
>>>>>>> 005da91dca40a8e213580acd6a641be7d29c52b8
}
