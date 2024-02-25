package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idReserva")
    private Long idReserva;
    
    @Column(name="numeroPuesto")
    private int numeroPuesto;
    
    @Column(name="estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario idUsuario;
    
	@ManyToOne
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idAdministrador")
    private Administrador idAdministrador;
	
    @ManyToOne
    @JoinColumn(name = "idViaje", referencedColumnName = "idViaje")
    private Viaje idViaje;

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reserva(Long idReserva, int numeroPuesto, String estado, Usuario idUsuario, Administrador idAdministrador,
			Viaje idViaje) {
		super();
		this.idReserva = idReserva;
		this.numeroPuesto = numeroPuesto;
		this.estado = estado;
		this.idUsuario = idUsuario;
		this.idAdministrador = idAdministrador;
		this.idViaje = idViaje;
	}
    
    

}