import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../servicios/usuario.service';
import { Usuario } from '../entities/usuario';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-modal-usuario-por-bus',
  standalone: true,
  imports: [CommonModule,FormsModule, RouterOutlet],
  templateUrl: './modal-usuario-por-bus.component.html',
  styleUrl: './modal-usuario-por-bus.component.css'
})
export class ModalUsuarioPorBusComponent  implements OnInit{
  usuarios:Usuario[];
  numeroBus:number;
  constructor(private UsuarioServicio: UsuarioService) { }
  ngOnInit(): void {
  }

  cerrarConsultor(){
    const modal= document.getElementById("consultor-usuarios-por-bus");
    if (modal!=null) {
      modal.style.display="none";
    } else {
      alert("Error al cerrar el consultor de usuarios por bus");
    }
  }

  UsuarioPorBus(id_bus: number) {
    this.UsuarioServicio.obtenerUsuarioPorBus(id_bus)
      .subscribe(
        (data: Usuario[]) => {
          if (data && data.length > 0) {
            this.usuarios = data;
            console.log(data);
          } else { 
            alert("No se encontraron usuarios para el bus proporcionado.");
          }
        },
        error => {
          console.error("Error al consultar los usuarios del bus:", error);
        }
      );
  }
  
}
