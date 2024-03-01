import { Component } from '@angular/core';

@Component({
  selector: 'app-modal-modificar-reserva',
  standalone: true,
  imports: [],
  templateUrl: './modal-modificar-reserva.component.html',
  styleUrl: './modal-modificar-reserva.component.css'
})
export class ModalModificarReservaComponent {
  cerrarModificador(){
    const modal = document.getElementById("modificador_reserva");
    if (modal!=null) {
      modal.style.display="none";
    } else {
      alert("Error al cerrar el modificador de reservas");
    }
  }
  modificarReserva(){
    
  }
}
