import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Perfilusuario } from '../_modelo/perfilusuario';

@Injectable({
  providedIn: 'root',
})
export class PerfilService {
  // confirmar url
  baseURL: string = 'http://localhost:3000/api/usuarios';
  constructor(private http: HttpClient) {}

  obtenerPerfil(id: number): Observable<Perfilusuario> {    
    return this.http.get<Perfilusuario>(`${this.baseURL}/${id}`);
  }

  actualizarPerfil(p: Perfilusuario): Observable<Perfilusuario> {
    return this.http.put<Perfilusuario>(`${this.baseURL}/${p.idPerfil}`, p);
  }

  eliminarPerfil(id: number) {
    return this.http.delete(`${this.baseURL}/${id}`);
  }

  altaPerfil(p: Perfilusuario): Observable<Perfilusuario> {
    return this.http.post<Perfilusuario>(`${this.baseURL}/${p.idPerfil}`, p);
  }
}
