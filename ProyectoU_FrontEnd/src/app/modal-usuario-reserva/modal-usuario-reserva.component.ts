import { Component, OnInit } from '@angular/core';
import { ListaDisponibilidaComponent } from '../lista-disponibilida/lista-disponibilida.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-modal-usuario-reserva',
  standalone: true,
  imports: [ListaDisponibilidaComponent, CommonModule, FormsModule],
  templateUrl: './modal-usuario-reserva.component.html',
  styleUrl: './modal-usuario-reserva.component.css'
})
export class ModalUsuarioReservaComponent implements OnInit{
  

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

  cerrarReservador(){
    const modal= document.getElementById("reservador");
    if (modal!=null) {
      modal.style.display="none";
    } else {
      alert("Error al cerrar el reservador");
    }
  }

  realizarReservacion(){

  } 
}
