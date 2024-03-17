package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.LikePublicacion;

public interface ILikePublicacionServicio extends ICRUD<LikePublicacion,Integer> {
    boolean dioLikeP(int idUsuario, int idPublicacion);

     int cantidadLikeP (int idPublicacion);



}
