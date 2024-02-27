package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private Long idAdministrador;
    
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    
    @Column(name = "contrasenia")
    private String contrasenia;

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(Long idAdministrador, String nombreUsuario, String contrasenia) {
		super();
		this.idAdministrador = idAdministrador;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
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

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
    
    
}