import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Historias } from '../_modelo/Historias';

@Injectable({
  providedIn: 'root'
})
export class ComentariosService {

  url:string = "http:/localhost:3000/api/historias"

  constructor(private http:HttpClient) { }

  getComentarios(): Observable<Historias[]>{
    return this.http.get<Historias[]>(this.url);
  }
}
