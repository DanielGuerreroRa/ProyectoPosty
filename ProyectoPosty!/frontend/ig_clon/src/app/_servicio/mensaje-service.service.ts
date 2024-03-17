import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Mensaje } from '../_modelo/Mensaje';
import { Publicaciones } from '../_modelo/Publicaciones';

@Injectable({
  providedIn: 'root'
})
export class MensajeServiceService {

  baseURL:string = 'http://localhost:3000/api/mensajes/de/'
  constructor(private http: HttpClient) { }

  getMsgById(id:number): Observable<Mensaje[]>{    
    return this.http.get<Mensaje[]>(`${this.baseURL}1/con/${id}`)
  }
}
