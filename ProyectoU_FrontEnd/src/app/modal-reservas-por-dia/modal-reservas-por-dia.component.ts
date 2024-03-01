import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-modal-reservas-por-dia',
  standalone: true,
  imports: [],
  templateUrl: './modal-reservas-por-dia.component.html',
  styleUrl: './modal-reservas-por-dia.component.css'
})
export class ModalReservasPorDiaComponent implements OnInit{
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

  buscarReservasPorDia(){
    //falta hacer
  }
}
