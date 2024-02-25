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
@Table(name = "administradores")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdministrador")
    private Long idAdministrador;
    
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    
    @Column(name = "contraseña")
    private String contraseña;
    
    @OneToMany(mappedBy = "idAdministrador") // Cambiado a mappedBy = "idAdministrador"
    private List<Reserva> idReservas;

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(String nombreUsuario, String contraseña) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public Long getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Long idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<Reserva> getIdReservas() {
		return idReservas;
	}

	public void setIdReservas(List<Reserva> idReservas) {
		this.idReservas = idReservas;
	}
    
    

}