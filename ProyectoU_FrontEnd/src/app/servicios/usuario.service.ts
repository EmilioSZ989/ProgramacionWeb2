import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../entities/usuario';
import { Reserva } from '../entities/reserva';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080/usuario';

  constructor(private httpClient: HttpClient) {}

  obtenerUsuarioPorBus(id_bus: number): Observable<Usuario[]> {
    return this.httpClient.post<Usuario[]>(`${this.apiUrl}/usuarios-por-bus`, id_bus);
  }

  guardarUsuario(usuario: Usuario): Observable<Usuario> {
    return this.httpClient.post<Usuario>(`${this.apiUrl}/guardarUsuarios`, usuario);
  }

  realizarReserva(foranikey: number[]): Observable<Reserva> {
    return this.httpClient.post<Reserva>(`${this.apiUrl}/realizarReserva`, foranikey);
  }
}