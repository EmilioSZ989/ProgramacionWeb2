import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-modal-usuario-por-bus',
  standalone: true,
  imports: [],
  templateUrl: './modal-usuario-por-bus.component.html',
  styleUrl: './modal-usuario-por-bus.component.css'
})
export class ModalUsuarioPorBusComponent  implements OnInit{
  ngOnInit(): void {
  }

  cerrarConsultor(){
    const modal= document.getElementById("consultor-usuarios-por-bus");
    if (modal!=null) {
      modal.style.display="none";
    } else {
      alert("Error al cerrar el consultor de usuarios por bus");
    }
  }

  buscarUsuariosPorbus(){

  }
}
