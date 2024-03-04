import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ListaDisponibilidad } from '../entities/lista-disponibilidad';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListaDisponibilidadService {

  constructor(private httpClient: HttpClient) {

  }

  //listar todos los viajes
  private bdurl="http://localhost:8080/lista_disponibilidad/viajes";

  obtenerListaViajes(): Observable <ListaDisponibilidad[]>{
    return this.httpClient.get<ListaDisponibilidad[]>(`${this.bdurl}`);
  }
  
}
