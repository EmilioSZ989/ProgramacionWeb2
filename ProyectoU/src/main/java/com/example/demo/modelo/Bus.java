package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bus")
    private Long idBus;
    
    @Column(name = "cupo_asientos")
    private int cupoAsientos;

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(Long idBus, int cupoAsientos) {
		super();
		this.idBus = idBus;
		this.cupoAsientos = cupoAsientos;
	}

	public Long getIdBus() {
		return idBus;
	}

	public void setIdBus(Long idBus) {
		this.idBus = idBus;
	}

	public int getCupoAsientos() {
		return cupoAsientos;
	}

	public void setCupoAsientos(int cupoAsientos) {
		this.cupoAsientos = cupoAsientos;
	}

    
}