import { Component, Input, OnInit } from '@angular/core';
import { ListaDisponibilidaComponent } from '../lista-disponibilida/lista-disponibilida.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Usuario } from '../entities/usuario';
import { UsuarioService } from '../servicios/usuario.service';
import { Reserva } from '../entities/reserva';
import { ListaDisponibilidad } from '../entities/lista-disponibilidad';

@Component({
  selector: 'app-modal-usuario-reserva',
  standalone: true,
  imports: [ListaDisponibilidaComponent, CommonModule, FormsModule],
  templateUrl: './modal-usuario-reserva.component.html',
  styleUrl: './modal-usuario-reserva.component.css'
})export class ModalUsuarioReservaComponent {
  nuevoUsuario: Usuario = new Usuario();
  @Input() viajeSeleccionado: number;

  constructor(private usuarioService: UsuarioService) {}

  abrirReservador(): void {
    const modal = document.getElementById("reservador");
    if (modal != null) {
      modal.style.display = "block";
    } else {
      alert("Error al abrir el reservador");
    }
  }

  cerrarReservador(): void {
    const modal = document.getElementById("reservador");
    if (modal != null) {
      modal.style.display = "none";
    } else {
      alert("Error al cerrar el reservador");
    }
  }

  realizarReservacion(): void {
    // Guardar el usuario
    this.usuarioService.guardarUsuario(this.nuevoUsuario).subscribe(
      (usuario: Usuario) => {
        console.log('Usuario guardado:', usuario);
        // Realizar la reserva con el usuario guardado
        if (this.viajeSeleccionado) {
          const foranikey = [usuario.cedula, this.viajeSeleccionado];
          this.usuarioService.realizarReserva(foranikey).subscribe(
            (reserva: Reserva) => {
              console.log('Reserva realizada:', reserva);
              alert('¡Reserva realizada correctamente!');
              this.cerrarReservador(); // Cerrar el modal automáticamente
            },
            (error: any) => {
              console.error('Error al realizar la reserva:', error);
              // Manejo de errores si es necesario
            }
          );
        } else {
          console.error('Error: No se ha seleccionado ningún viaje.');
        }
      },
      (error: any) => {
        console.error('Error al guardar el usuario:', error);
        // Manejo de errores si es necesario
      }
    );
  }
}