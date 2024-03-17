package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.modelo.LikeComentario;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.ILikeComentarioRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.ILikePublicacionRepositorio;
import com.corenetworks.ProyectoFinal.servicio.ILikeComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILikeComentarioServicioimpl extends ICRUDimpl<LikeComentario,Integer> implements ILikeComentarioServicio {

    @Autowired
    ILikeComentarioRepositorio repositorio;

    @Override
    protected IGeneralRepositorio<LikeComentario, Integer> getRepo() {
        return repositorio;
    }
    @Override
    public boolean dioLikeC(int idUsuario, int idComentario) {
        return repositorio.dioLikeC(idUsuario,idComentario);
    }

    @Override
    public int cantidadLikeC(int idComentario) {
        return repositorio.cantidadDeLikesC(idComentario);
    }
}
