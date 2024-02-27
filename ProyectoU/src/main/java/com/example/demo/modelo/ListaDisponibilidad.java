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
@Table(name = "lista_disponibilidad")
public class ListaDisponibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_disponibilidad")
    private Long idListaDisponibilidad;
    
    @Column(name = "destino")
    private String destino;
    
    @Column(name = "fecha")
    private String fecha;
    
    @Column(name = "hora_salida")
    private String horaSalida;
   
    @Column(name="total_pagar")
    private double totalPagar;
    
    @Column(name = "cupo_disponible")
    private int cupoDisponible;

    @ManyToOne
    @JoinColumn(name = "id_automovil")
    private Bus idBus;

	public ListaDisponibilidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListaDisponibilidad(Long idListaDisponibilidad, String destino, String fecha, String horaSalida,
			double totalPagar, int cupoDisponible, Bus idBus) {
		super();
		this.idListaDisponibilidad = idListaDisponibilidad;
		this.destino = destino;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.totalPagar = totalPagar;
		this.cupoDisponible = cupoDisponible;
		this.idBus = idBus;
	}

	public Long getIdListaDisponibilidad() {
		return idListaDisponibilidad;
	}

	public void setIdListaDisponibilidad(Long idListaDisponibilidad) {
		this.idListaDisponibilidad = idListaDisponibilidad;
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

	public Bus getIdBus() {
		return idBus;
	}

	public void setIdBus(Bus idBus) {
		this.idBus = idBus;
	}
    
    
}