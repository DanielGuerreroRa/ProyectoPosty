package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.modelo.LikePublicacion;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.ILikePublicacionRepositorio;
import com.corenetworks.ProyectoFinal.servicio.ILikePublicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILikePublicacionServicioimpl extends ICRUDimpl<LikePublicacion,Integer> implements ILikePublicacionServicio {
    @Autowired
    ILikePublicacionRepositorio repositorio;
    @Override
    protected IGeneralRepositorio<LikePublicacion, Integer> getRepo() {
        return repositorio;
    }

    @Override
    public boolean dioLikeP(int idUsuario, int idPublicacion) {
        return repositorio.dioLikeP(idUsuario,idPublicacion);
    }

    @Override
    public int cantidadLikeP(int idPublicacion) {
        return repositorio.cantidadDeLikesP(idPublicacion);
    }
}
