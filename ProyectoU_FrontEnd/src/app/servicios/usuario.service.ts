import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../entities/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  constructor(private httpClient: HttpClient) {

  }

  private CpCURL="http://localhost:8080/usuario/usuarios-por-bus";

  obtenerUsuarioPorBus(id_bus: number): Observable<Usuario[]> {
    return this.httpClient.post<Usuario[]>(`${this.CpCURL}`, id_bus);
  }
}
