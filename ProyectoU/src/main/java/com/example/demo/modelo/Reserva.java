package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;

import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;
    
    @Column(name = "numero_puesto")
    private int numeroPuesto;
    
    @Column(name = "estado")
    private Boolean estado;
    
    @Column(name = "fecha_reserva") // Cambiado el nombre de la columna para seguir la convención de nomenclatura Java (camelCase)
    private LocalDate fechaReserva;

    @ManyToOne
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private Usuario cedula; // Cambiado el nombre de la variable para ser más representativo
    
    @ManyToOne
    @JoinColumn(name = "id_lista_disponibilidad", referencedColumnName = "id_lista_disponibilidad")
    private ListaDisponibilidad id_lista_disponibilidad; // Cambiado el nombre de la variable para ser más representativo


    public Reserva() {
        super();
    }

    public Reserva(Long idReserva, int numeroPuesto, Boolean estado, LocalDate fechaReserva, Usuario cedula,
            ListaDisponibilidad id_lista_disponibilidad) {
        super();
        this.idReserva = idReserva;
        this.numeroPuesto = numeroPuesto;
        this.estado = estado;
        this.fechaReserva = fechaReserva;
        this.cedula = cedula;
        this.id_lista_disponibilidad = id_lista_disponibilidad;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Usuario getCedula() {
        return cedula;
    }

    public void setCedula(Usuario cedula) {
        this.cedula = cedula;
    }

    public ListaDisponibilidad getId_lista_disponibilidad() {
        return id_lista_disponibilidad;
    }

    public void setId_lista_disponibilidad(ListaDisponibilidad id_lista_disponibilidad) {
        this.id_lista_disponibilidad = id_lista_disponibilidad;
    }

    // Método que se ejecuta antes de guardar la reserva para establecer la fecha de reserva
    @PrePersist
    protected void onCreate() {
        this.fechaReserva = LocalDate.now();
    }
}
