import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../_modelo/Usuario';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  url: string = "http://localhost:3000/api/usuarios";


  constructor(private http: HttpClient) { }

  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.url);
  }


  getUsuarioPorId(idUsuario: number): Observable<Usuario> {
    const urlUsuario = `${this.url}/${idUsuario}`;
    return this.http.get<Usuario>(urlUsuario);
  }
  
  getImagenUsuarios(rutaContenido: string): Observable<Usuario[]> {
    const urlImagen = `${this.url}/imagen/${rutaContenido}`;
    return this.http.get<Usuario[]>(urlImagen);
  }
}