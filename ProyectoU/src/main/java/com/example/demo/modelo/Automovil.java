package com.example.demo.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "automoviles")
public class Automovil {
    @Id
    @Column(name = "id_automovil")
    private Long idAutomovil;
    
    @Column(name = "capacidad_asientos")
    private int capacidadAsientos;

    @OneToMany(mappedBy = "idAutomovil")
    private List<Disponibilidad> idDisponibilidades;

    // Constructores
    public Automovil() {
    }
    
    public Automovil(Long idAutomovil, int capacidadAsientos, List<Disponibilidad> idDisponibilidades) {
		super();
		this.idAutomovil = idAutomovil;
		this.capacidadAsientos = capacidadAsientos;
		this.idDisponibilidades = idDisponibilidades;
	}

	// Getters y setters
    public Long getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Long idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public int getCapacidadAsientos() {
        return capacidadAsientos;
    }

    public void setCapacidadAsientos(int capacidadAsientos) {
        this.capacidadAsientos = capacidadAsientos;
    }

    public List<Disponibilidad> getDisponibilidades() {
        return idDisponibilidades;
    }

    public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
        this.idDisponibilidades = disponibilidades;
    }
}
