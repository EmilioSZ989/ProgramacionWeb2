package com.example.demo.controlador;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Reserva;
import com.example.demo.repositorio.repositorioReserva;
import java.util.Optional;

@RestController
@RequestMapping("/Reserva")
public class ControladorReserva {
	@Autowired
	private repositorioReserva repositorio;
	
	@GetMapping("/Reserva")
	public List<Reserva> ListarReservas(){
		return repositorio.findAll();
	}
        
        @GetMapping("/eliminar")
        public String Reserva() {
            this.repositorio.deleteById(1260L);
            return "reserva eliminada";
        }
                
        @GetMapping("/guardar")
        public List<Reserva> guardarReserva(){
            Reserva e= new Reserva(1260L,12, "Disponible", 1,1,1 );
            this.repositorio.save(e);
            return this.repositorio.findAll();
        }
}
