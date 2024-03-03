import { Component, OnInit } from '@angular/core';
import { ReservaService } from '../servicios/reserva.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Reserva } from '../entities/reserva';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-modal-consulta-reserva',
  standalone: true,
  imports: [CommonModule,FormsModule, RouterOutlet],
  templateUrl: './modal-consulta-reserva.component.html',
  styleUrl: './modal-consulta-reserva.component.css'
})
export class ModalConsultaReservaComponent implements OnInit {
  reservas: Reserva[]; // Inicializamos como un array vacío
  cedula: number;
  constructor(private reservaServicio: ReservaService) { }

  ngOnInit(): void {
  }

  abrirConsultor() {
    const modal = document.getElementById("consultor-reserva");
    if (modal != null) {
      modal.style.display = "block";
    } else {
      alert("Error al abrir consultor de reservas");
    }
  }

  cerrarConsultor() {
    const modal = document.getElementById("consultor-reserva");
    if (modal != null) {
      modal.style.display = "none";
    } else {
      alert("Error al cerrar el consultor de reservas");
    }
  }

  consultarReserva(cedula: number) {
    this.reservaServicio.obtenerReservaCedula(cedula)
      .subscribe(
        (data: Reserva[]) => {
          if (data && data.length > 0) {
            this.reservas = data;
            console.log(data);
          } else {
            alert("No se encontraron reservas para la cédula proporcionada.");
          }
        },
        error => {
          console.error("Error al consultar la reserva:", error);
        }
      );
  }
  
  cancelarReservaUsuario(idReserva: number) {
    const confirmacion = confirm("¿Está seguro que desea cancelar la reserva?");
    if (confirmacion) {
      this.reservaServicio.cancelarReservaUsuario(idReserva).subscribe(
        () => {
          this.consultarReserva(this.cedula);
          alert("La reserva ha sido cancelada exitosamente.");
        },
        error => {
          console.error('Error al eliminar empleado:', error);
        }
      );
    }
  }
  
  
  
}

