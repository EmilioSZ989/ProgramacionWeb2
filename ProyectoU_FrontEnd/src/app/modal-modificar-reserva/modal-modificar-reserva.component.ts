import { Component, Input, OnInit } from '@angular/core';
import { AdministradorService } from '../servicios/administrador.service';
import { Reserva } from '../entities/reserva';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-modal-modificar-reserva',
  standalone: true,
  imports: [CommonModule,FormsModule, RouterOutlet],
  templateUrl: './modal-modificar-reserva.component.html',
  styleUrl: './modal-modificar-reserva.component.css'
})
export class ModalModificarReservaComponent implements OnInit {

  reserva: Reserva = new Reserva(); // Objeto para almacenar los datos del formulario

  constructor(private adminServicio: AdministradorService) {}

  ngOnInit(): void {
  }

  cerrarModificador(): void {
    const modal = document.getElementById("modificador_reserva");
    if (modal != null) {
      modal.style.display = "none";
    } else {
      alert("Error al cerrar el modificador de reservas");
    }
  }

  modificarReserva(): void {
    // Llamar al servicio para enviar la reserva al backend
    this.adminServicio.modificarDatosReserva(this.reserva).subscribe(
      (response: boolean) => {
        if (response) {
          alert("Reserva modificada correctamente.");
        } else {
          alert("La reserva no pudo ser modificada. El ID de reserva no fue encontrado en la base de datos.");
        }
        this.cerrarModificador(); // Cerrar el modal después de procesar la respuesta
      },
      error => {
        console.error("Error al modificar la reserva:", error);
        alert("Error al modificar la reserva. Por favor, inténtelo de nuevo.");
      }
    );
  }
}
  
  
