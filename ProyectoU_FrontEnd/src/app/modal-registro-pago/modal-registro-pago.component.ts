import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-modal-registro-pago',
  standalone: true,
  imports: [],
  templateUrl: './modal-registro-pago.component.html',
  styleUrl: './modal-registro-pago.component.css'
})
export class ModalRegistroPagoComponent implements OnInit {
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
  registrarPago(){

  }
}
