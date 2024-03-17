package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.LikeComentario;

public interface ILikeComentarioServicio extends ICRUD<LikeComentario,Integer> {
    boolean dioLikeC(int idUsuario, int idComentario);
    int cantidadLikeC (int idComentario);
}
