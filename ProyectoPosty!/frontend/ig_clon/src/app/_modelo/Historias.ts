import { Usuario } from "./Usuario";

export interface Historias{
    idHistorias:number;
    contenido:string;
    publicas:boolean;
    activo:boolean;
    fcreacion:Date;
    hCreacion:Date;
    fFinal:Date;
    usuario:Usuario;
}