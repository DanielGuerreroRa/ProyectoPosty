package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.modelo.LikeHistoria;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.ILikeHistoriaRepositorio;
import com.corenetworks.ProyectoFinal.servicio.ILikeHistoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILikeHistoriaServicioimpl extends ICRUDimpl<LikeHistoria,Integer> implements ILikeHistoriaServicio {
   @Autowired
    ILikeHistoriaRepositorio repositorio;

    @Override
    protected IGeneralRepositorio<LikeHistoria, Integer> getRepo() {
        return repositorio;
    }
    @Override
    public boolean dioLikeH(int idUsuario, int idHistoria) {
        return repositorio.dioLikeH(idUsuario,idHistoria);
    }

    @Override
    public int cantidadLikeH(int idHistoria) {
        return repositorio.cantidadDeLikesH(idHistoria);
    }
}
