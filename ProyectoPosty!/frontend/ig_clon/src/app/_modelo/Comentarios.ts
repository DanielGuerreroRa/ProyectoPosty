import { Usuario } from "./Usuario";

export interface Comentarios {
    idPublicacion: number;
    idComentario: number;
    likes: number;
    mensajes: string;
    respuestasUsuarios: string;
    hCreacion: string;
    fCreacion: string;
    usuario:Usuario
}