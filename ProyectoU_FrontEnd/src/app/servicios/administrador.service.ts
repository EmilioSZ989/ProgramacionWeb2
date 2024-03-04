import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdministradorService {

  constructor(private httpClient: HttpClient) {

  }
  private ISURL="http://localhost:8080/administrador/ingresar_plataforma";

  obtenerValidacionLogin(credencialesUsuario: string[]): Observable<boolean> {
    return this.httpClient.post<boolean>(`${this.ISURL}`, credencialesUsuario);
  }

  private RPURL="http://localhost:8080/administrador/registrar_pago";

  registrarPagoReserva(id_reserva : number): Observable<boolean>{
    return this.httpClient.post<boolean>(`${this.RPURL}`, id_reserva);
  }
}
