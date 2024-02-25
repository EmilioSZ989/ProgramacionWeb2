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
@Table(name = "viajes")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViaje")
    private Long idViaje;
    
    @Column(name = "destino")
    private String destino;
    
    @Column(name = "fecha")
    private String fecha;
    
    @Column(name = "horaSalida")
    private String horaSalida;
   
    @Column(name="totalPagar")
    private double totalPagar;
    
    @Column(name = "cupoDisponible")
    private int cupoDisponible;

    @ManyToOne
    @JoinColumn(name = "idAutomovil")
    private Automovil idAutomovil;

	public Viaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Viaje(Long idViaje, String destino, String fecha, String horaSalida, double totalPagar, int cupoDisponible,
			Automovil automovil) {
		super();
		this.idViaje = idViaje;
		this.destino = destino;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.totalPagar = totalPagar;
		this.cupoDisponible = cupoDisponible;
		this.idAutomovil = automovil;
	}

	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public int getCupoDisponible() {
		return cupoDisponible;
	}

	public void setCupoDisponible(int cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}

	public Automovil getAutomovil() {
		return idAutomovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.idAutomovil = automovil;
	}
    
    

}
