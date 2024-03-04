import { Component, OnInit } from '@angular/core';
import { ReservaService } from '../servicios/reserva.service';
import { Reserva } from '../entities/reserva';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-modal-reservas-por-dia',
  standalone: true,
  imports: [CommonModule,FormsModule, RouterOutlet],
  templateUrl: './modal-reservas-por-dia.component.html',
  styleUrl: './modal-reservas-por-dia.component.css'
})
export class ModalReservasPorDiaComponent implements OnInit {

  reservasDelDia: Reserva[]; // Cambié el nombre de la variable

  constructor(private reservaServicio: ReservaService) { }
  
  ngOnInit(): void {
  }

  cerrarConsultor(){
    const modal= document.getElementById("consultor-reservas-por-dia");
    if (modal!=null) {
      modal.style.display="none";
    } else {
      alert("Error al cerrar el consultor de reservas por dia");
    }
  }

  consultarReservaHoy() {
    this.reservaServicio.obtenerReservaHoy()
      .subscribe(
        (data: Reserva[]) => {
          if (data && data.length > 0) {
            this.reservasDelDia = data; // Asignar las reservas a reservasDelDia
            console.log(data);
          } else { 
            alert("No se encontraron reservas el dia de hoy.");
          }
        },
        error => {
          console.error("Error al consultar las reservas de hoy:", error);
        }
      ); 
  }
}