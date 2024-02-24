package com.example.demo.modelo;

import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy = "idAdministrador")
    private List<Disponibilidad> idDisponibilidades;

    // Constructores
    public Administrador() {
    }
    
    public Administrador(Long idAdministrador, String nombreUsuario, String contraseña,
			List<Disponibilidad> idDisponibilidades) {
		super();
		this.idAdministrador = idAdministrador;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.idDisponibilidades = idDisponibilidades;
	}

	// Getters y setters
    public Long getId() {
        return idAdministrador;
    }

    public void setId(Long id) {
        this.idAdministrador = id;
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

    public List<Disponibilidad> getDisponibilidades() {
        return idDisponibilidades;
    }

    public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
        this.idDisponibilidades = disponibilidades;
    }
}
