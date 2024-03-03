import { HttpClient } from '@angular/common/http';
import { Injectable, Optional } from '@angular/core';
import { Observable } from 'rxjs';
import { Reserva } from '../entities/reserva';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  constructor(private httpClient: HttpClient) {

  }

  //consultar reservas por la cedula
  private CpCURL="http://localhost:8080/reserva/consultar_reserva";

  obtenerReservaCedula(cedula: number): Observable<Reserva[]> {
    return this.httpClient.post<Reserva[]>(`${this.CpCURL}`, cedula);
  }
  
  private CRURL="http://localhost:8080/reserva/cancelar_reserva";

  cancelarReservaUsuario(idReserva: number): Observable<any>{
    return this.httpClient.post(`${this.CRURL}`,idReserva);
  }
}
