import { Component, Input, OnInit } from '@angular/core';
import { ModalUsuarioReservaComponent } from '../modal-usuario-reserva/modal-usuario-reserva.component';

@Component({
  selector: 'app-lista-disponibilida',
  standalone: true,
  imports: [ModalUsuarioReservaComponent],
  templateUrl: './lista-disponibilida.component.html',
  styleUrl: './lista-disponibilida.component.css'
})
export class ListaDisponibilidaComponent implements OnInit{
  ngOnInit(): void {
  }
  abrirReservador(){
    const modal = document.getElementById("reservador");
    if (modal!=null) {
      modal.style.display="block";
    } else {
      alert("Error al abrir el reservador");
    }
  }
}
