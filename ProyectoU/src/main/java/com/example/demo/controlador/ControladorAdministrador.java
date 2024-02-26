package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Administrador;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.repositorioAdministrador;
@RestController
@RequestMapping("/administrador")
public class ControladorAdministrador {
	@Autowired
	private repositorioAdministrador repositorioAdministrador;
	
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
	
}
