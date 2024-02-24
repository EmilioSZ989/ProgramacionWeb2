package com.example.demo.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "disponibilidades")
public class Disponibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDisponibilidad")
    private Long idDisponibilidad;
    
    @Column(name = "destino")
    private String destino;
    
    @Column(name = "fecha")
    private String fecha;
    
    @Column(name = "hora_salida")
    private String horaSalida;
    
    @Column(name = "cantidad_puestos")
    private int cantidadPuestos;

    @ManyToOne
    @JoinColumn(name = "idAutomovil")
    private Automovil idAutomovil;

    @OneToMany(mappedBy = "idDisponibilidad")
    private List<Reserva> idReservas;

    @ManyToOne
    @JoinColumn(name = "idAdministrador")
    private Administrador idAdministrador;

    // Constructores
    public Disponibilidad() {
    }
    
    public Disponibilidad(Long idDisponibilidad, String destino, String fecha, String horaSalida, int cantidadPuestos,
			Automovil idAutomovil, List<Reserva> idReservas, Administrador idAdministrador) {
		super();
		this.idDisponibilidad = idDisponibilidad;
		this.destino = destino;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.cantidadPuestos = cantidadPuestos;
		this.idAutomovil = idAutomovil;
		this.idReservas = idReservas;
		this.idAdministrador = idAdministrador;
	}

	// Getters y setters
    public Long getId() {
        return idDisponibilidad;
    }

    public void setId(Long id) {
        this.idDisponibilidad = id;
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

    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    public void setCantidadPuestos(int cantidadPuestos) {
        this.cantidadPuestos = cantidadPuestos;
    }

    public Automovil getAutomovil() {
        return idAutomovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.idAutomovil = automovil;
    }

    public List<Reserva> getReservas() {
        return idReservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.idReservas = reservas;
    }

    public Administrador getAdministrador() {
        return idAdministrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.idAdministrador = administrador;
    }
}
