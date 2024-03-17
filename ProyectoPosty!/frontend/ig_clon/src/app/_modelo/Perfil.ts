import { Usuario } from "./Usuario";

export interface Perfil{

idPerfil:number,
numSeguidores:number,
numSiguiendo:number,
numPublicaciones:number,
imgPerfil:string,
descripcion:string,
usuario:Usuario,
}