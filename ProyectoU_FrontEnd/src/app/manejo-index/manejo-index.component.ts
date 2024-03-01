import { Component, OnInit } from '@angular/core';
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { PresentacionEmpresaComponent } from '../presentacion-empresa/presentacion-empresa.component';

@Component({
  selector: 'app-manejo-index',
  standalone: true,
  imports: [NavBarComponent,PresentacionEmpresaComponent],
  templateUrl: './manejo-index.component.html',
  styleUrl: './manejo-index.component.css'
})
export class ManejoIndexComponent implements OnInit{
  ngOnInit(): void {
  }

}
