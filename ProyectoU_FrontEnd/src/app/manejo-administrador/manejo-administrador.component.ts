import { Component, OnInit } from '@angular/core';
import { FuncionesAdministradorComponent } from '../funciones-administrador/funciones-administrador.component';

@Component({
  selector: 'app-manejo-administrador',
  standalone: true,
  imports: [FuncionesAdministradorComponent],
  templateUrl: './manejo-administrador.component.html',
  styleUrl: './manejo-administrador.component.css'
})
export class ManejoAdministradorComponent implements OnInit{
  ngOnInit(): void {
  }

}
