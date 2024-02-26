package com.example.demo.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Administrador;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.Viaje;
import com.example.demo.repositorio.*;

import java.util.Optional;

@RestController
@RequestMapping("/Reserva")
public class ControladorReserva {
	@Autowired
	private repositorioReserva repositorioReserva;
	
	@Autowired
	private repositorioUsuario repositorioUsuario;
	
	@Autowired
	private repositorioAdministrador repositorioAdministrador;
	
	@Autowired
	private repositorioViaje repositorioViaje;
	
	@GetMapping("/reservas")
	public List<Reserva> ListarReservas(){
		return repositorioReserva.findAll();
	}
    @GetMapping("/eliminar/{id}")
    public String Reserva(@PathVariable Long id) {
        this.repositorioReserva.deleteById(id);
        return "reserva eliminada";
    }
    
        @GetMapping("/guardar")
        public List<Reserva> guardarReserva(){
        	Usuario user = repositorioUsuario.findById(Long.valueOf(2)).orElse(null);
        	Administrador admin = repositorioAdministrador.findById(Long.valueOf(1)).orElse(null);
        	Viaje viaje = repositorioViaje.findById(Long.valueOf(2)).orElse(null);
            Reserva e= new Reserva(4,"Disponible",user,admin,viaje);
            this.repositorioReserva.save(e);
            return this.repositorioReserva.findAll();
        }


}
