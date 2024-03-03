import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterOutlet } from '@angular/router';
import { AdministradorService } from '../servicios/administrador.service';

@Component({
  selector: 'app-form-login-admin',
  standalone: true,
  imports: [RouterOutlet,FormsModule,CommonModule],
  templateUrl: './form-login-admin.component.html',
  styleUrl: './form-login-admin.component.css'
})
export class FormLoginAdminComponent implements OnInit {
  nombreUsuario: string;
  contrasenia: string;

  constructor(private administradorServicio: AdministradorService, private router: Router) {}

  ngOnInit(): void {
    // Código de inicialización
  }
  
  iniciarSesion() {
    const credencialesUsuario: string[] = [this.nombreUsuario, this.contrasenia];
    this.administradorServicio.obtenerValidacionLogin(credencialesUsuario)
      .toPromise()//yo le mando unos datos y si no tengo esos datos listos paila.
      .then((inicioSesionExitoso: boolean | undefined) => {
        console.log("Inicio de sesión exitoso:", inicioSesionExitoso);
        if (inicioSesionExitoso) {
          this.router.navigate(['/manejo-administrador']);
        } else {
          alert("Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
        }
      })
      .catch(error => {
        console.error('Error al iniciar sesión:', error);
      });
  }
  

}
