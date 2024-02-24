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
    
    @Column(name="destino")
    private String destino;
    
    @Column(name="fecha")
    private String fecha;
    
    @Column(name="horaSalida")
    private String horaSalida;
    
    @Column(name="numeroPuesto")
    private int numeroPuesto;
    
    @Column(name="estado")
    private String estado;
    
    @Column(name="totalPagar")
    private double totalPagar;

    @ManyToOne
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idDisponibilidad",referencedColumnName = "idDisponibilidad")
    private Disponibilidad idDisponibilidad;

    // Constructor
    public Reserva() {
    }
    
    public Reserva(Long idReserva, String destino, String fecha, String horaSalida, int numeroPuesto, String estado,
			double totalPagar, Usuario idUsuario, Disponibilidad idDisponibilidad) {
		super();
		this.idReserva = idReserva;
		this.destino = destino;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.numeroPuesto = numeroPuesto;
		this.estado = estado;
		this.totalPagar = totalPagar;
		this.idUsuario = idUsuario;
		this.idDisponibilidad = idDisponibilidad;
	}

	// Getters y setters
    public Long getId() {
        return idReserva;
    }

    public void setId(Long id) {
        this.idReserva = id;
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

    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Usuario getUsuario() {
        return idUsuario;
    }

    public void setUsuario(Usuario usuario) {
        this.idUsuario = usuario;
    }

    public Disponibilidad getDisponibilidad() {
        return idDisponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.idDisponibilidad = disponibilidad;
    }
}
