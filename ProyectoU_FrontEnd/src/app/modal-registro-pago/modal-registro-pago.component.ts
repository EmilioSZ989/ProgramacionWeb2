import { Component, OnInit } from '@angular/core';
import { AdministradorService } from '../servicios/administrador.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-modal-registro-pago',
  standalone: true,
  imports: [CommonModule,FormsModule, RouterOutlet],
  templateUrl: './modal-registro-pago.component.html',
  styleUrl: './modal-registro-pago.component.css'
})
export class ModalRegistroPagoComponent implements OnInit {
  idReserva: number; // Propiedad para almacenar el ID de la reserva

  constructor(private adminService: AdministradorService) { }

  ngOnInit(): void {
  }

  cerrarConsultor(){
    const modal= document.getElementById("registro-pago");
    if (modal!=null) {
      modal.style.display="none";
    } else {
      alert("Error al cerrar el registrador de pago");
    }
  }

  registrarPago(idReserva: number): void {
    this.adminService.registrarPagoReserva(idReserva).subscribe(
      (response: boolean) => {
        if (response) {
          alert("Pago registrado exitosamente.");
          // Aquí puedes realizar otras acciones si es necesario
        } else {
          alert("La reserva ya estaba pagada o no se encontró.");
        }
        this.cerrarConsultor(); // Cerrar el modal después de procesar la respuesta
      },
      error => {
        console.error("Error al registrar el pago:", error);
        alert("Error al registrar el pago. Por favor, inténtelo de nuevo.");
      }
    );
  }
}
