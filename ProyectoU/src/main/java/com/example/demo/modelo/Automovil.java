package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "automoviles")
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutomovil")
    private Long idAutomovil; // Cambiado el tipo de dato de numeroAutomovil a Long y agregada la generación automática de valor
    
    @Column(name = "cupoAsientos")
    private int cupoAsientos;

    @OneToMany(mappedBy = "idAutomovil")
    private List<Viaje> idViajes; // Relación uno a muchos con Viaje

	public Automovil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Automovil(Long idAutomovil, int cupoAsientos) {
		super();
		this.idAutomovil = idAutomovil;
		this.cupoAsientos = cupoAsientos;
	}

	public Long getIdAutomovil() {
		return idAutomovil;
	}

	public void setIdAutomovil(Long idAutomovil) {
		this.idAutomovil = idAutomovil;
	}

	public int getCupoAsientos() {
		return cupoAsientos;
	}

	public void setCupoAsientos(int cupoAsientos) {
		this.cupoAsientos = cupoAsientos;
	}

	public List<Viaje> getIdViajes() {
		return idViajes;
	}

	public void setIdViajes(List<Viaje> idViajes) {
		this.idViajes = idViajes;
	}
    
    

}