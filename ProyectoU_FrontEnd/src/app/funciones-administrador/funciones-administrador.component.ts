import { Component, OnInit } from '@angular/core';
import { ModalConsultaReservaComponent } from '../modal-consulta-reserva/modal-consulta-reserva.component';
import { ListaDisponibilidaComponent } from '../lista-disponibilida/lista-disponibilida.component';
import { ModalModificarReservaComponent } from '../modal-modificar-reserva/modal-modificar-reserva.component';
import { ModalUsuarioPorBusComponent } from '../modal-usuario-por-bus/modal-usuario-por-bus.component';
import { ModalReservasPorDiaComponent } from '../modal-reservas-por-dia/modal-reservas-por-dia.component';
import { ModalRegistroPagoComponent } from '../modal-registro-pago/modal-registro-pago.component';

@Component({
  selector: 'app-funciones-administrador',
  standalone: true,
  imports: [ModalConsultaReservaComponent,ListaDisponibilidaComponent,ModalModificarReservaComponent, ModalUsuarioPorBusComponent, ModalReservasPorDiaComponent, ModalRegistroPagoComponent],
  templateUrl: './funciones-administrador.component.html',
  styleUrl: './funciones-administrador.component.css'
})
export class FuncionesAdministradorComponent implements OnInit{
  ngOnInit(): void {
    
  }
  abrirConBoton(idElemento: string) {
    const elemento = document.getElementById(idElemento);
    if (elemento != null) {
      // Mostrar el componente correspondiente al botón presionado
      elemento.style.display = "block";
      
      // Si el botón presionado no es "Realizar Reserva", ocultar el componente de lista disponibilidad
      if (idElemento !== 'container_listas') {
        const listaDisponibilidad = document.getElementById('container_listas');
        if (listaDisponibilidad != null) {
          listaDisponibilidad.style.display = "none";
        }
      }
    } else {
      alert("Error al abrir el elemento con el ID: " + idElemento);
    }
  }
  
}
