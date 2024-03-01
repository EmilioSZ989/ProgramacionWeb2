import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-modal-consulta-reserva',
  standalone: true,
  imports: [],
  templateUrl: './modal-consulta-reserva.component.html',
  styleUrl: './modal-consulta-reserva.component.css'
})
export class ModalConsultaReservaComponent implements OnInit{
  ngOnInit(): void {
  }
  abrirConsultor(){
    const modal = document.getElementById("consultor-reserva");
    if (modal!=null) {
      modal.style.display="block";
    } else {
      alert("Error al abrir consultor de reservas");
    }
  }

  cerrarConsultor(){
    const modal= document.getElementById("consultor-reserva");
    if (modal!=null) {
      modal.style.display="none";
    } else {
      alert("Error al cerrar el consultor de reservas");
    }
  }

  consultarReserva(){

  }
}
