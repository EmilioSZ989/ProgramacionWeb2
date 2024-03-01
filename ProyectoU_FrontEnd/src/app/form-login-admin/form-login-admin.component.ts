import { Component, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-form-login-admin',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './form-login-admin.component.html',
  styleUrl: './form-login-admin.component.css'
})
export class FormLoginAdminComponent implements OnInit {
      ngOnInit(): void {

      }
      constructor(private router: Router) {}
      iniciarSesion() {
          // Aquí colocas la lógica de inicio de sesión
          // Luego, rediriges a la ruta deseada
          this.router.navigate(['/manejo-administrador']);
      }
  }
  

