import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Publicaciones } from '../_modelo/Publicaciones';
import { Observable } from 'rxjs';
import { PublicacionPublicar } from '../_modelo/PublicacionPublicar';
import { Comentarios } from '../_modelo/Comentarios';
import { ComentarioPost } from '../_modelo/ComentarioPost';

@Injectable({
  providedIn: 'root'
})
export class PublicacionesService {

  url:string = "http://localhost:3000/api/publicaciones"
  likeURL:string = "http://localhost:3000/api/like";
  comentarioURL:string = "http://localhost:3000/api/comentario/enviarcomentario/de";

  constructor(private http:HttpClient) { }

  getPublicaciones(): Observable<Publicaciones[]>{
    return this.http.get<Publicaciones[]>(this.url);
  }
  postPublicacion(idUsuario:number, publicacion:PublicacionPublicar): Observable<PublicacionPublicar>{
    return this.http.post<PublicacionPublicar>(`${this.url}/${idUsuario}`, publicacion);
  }
  darLike(idPublicacion:number): Observable<Publicaciones>{
    return this.http.post<Publicaciones>(`${this.likeURL}/${idPublicacion}/de/1`, idPublicacion)
  }
  comentar(idPublicacion:number, comentario:ComentarioPost):Observable<ComentarioPost>{
    return this.http.post<ComentarioPost>(`${this.comentarioURL}/${idPublicacion}/de/1`, comentario)
  }
}