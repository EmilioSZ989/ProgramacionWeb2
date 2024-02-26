package com.example.demo.modelo;



import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private Long idUsuario;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellidos")
    private String apellidos;
    
    @Column(name="cedula")
    private String cedula;
    
    @Column(name="telefono")
    private String telefono;
    
    @Column(name="fechaNacimiento")
    private Date fechaNacimiento; // Cambiado el tipo de dato a Date

    @OneToMany(mappedBy = "idUsuario")
    private List<Reserva> idReservas; // Relación uno a muchos con Reserva

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Long idUsuario, String nombre, String apellidos, String cedula, String telefono,
			Date fechaNacimiento) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Reserva> getReservas() {
		return idReservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.idReservas = reservas;
	}
    
    

}
