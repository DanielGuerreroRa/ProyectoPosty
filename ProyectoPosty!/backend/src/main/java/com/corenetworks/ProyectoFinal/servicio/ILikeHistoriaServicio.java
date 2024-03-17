package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.LikeHistoria;

public interface ILikeHistoriaServicio extends ICRUD<LikeHistoria,Integer> {
    boolean dioLikeH(int idUsuario, int idHistoria);
    int cantidadLikeH (int idHistoria);
}
