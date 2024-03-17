import { Comentarios } from "./Comentarios";
import { Usuario } from "./Usuario";

export interface Publicaciones{
    idPublicacion:number,
    descripcion:string,
    cantidadLikes:number,
    rutaContenido:string,
    urlCompartir:string,
    fCreacion:Date,
    hCreacion:Date,
    usuario:Usuario,
    comentarios:Comentarios[]
}