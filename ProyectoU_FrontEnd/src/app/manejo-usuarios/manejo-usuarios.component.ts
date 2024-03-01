import { Component, OnInit } from '@angular/core';
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { PresentacionEmpresaComponent } from '../presentacion-empresa/presentacion-empresa.component';
import { ListaDisponibilidaComponent } from '../lista-disponibilida/lista-disponibilida.component';
import { ModalConsultaReservaComponent } from '../modal-consulta-reserva/modal-consulta-reserva.component';
import { ModalUsuarioReservaComponent } from '../modal-usuario-reserva/modal-usuario-reserva.component';

@Component({
  selector: 'app-manejo-usuarios',
  standalone: true,
  imports: [NavBarComponent, ListaDisponibilidaComponent, ModalConsultaReservaComponent, ModalUsuarioReservaComponent],
  templateUrl: './manejo-usuarios.component.html',
  styleUrl: './manejo-usuarios.component.css'
})
export class ManejoUsuariosComponent implements OnInit{
  ngOnInit(): void {
  }

}
