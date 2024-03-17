package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.modelo.Publicacion;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IPublicacionRepositorio;
import com.corenetworks.ProyectoFinal.servicio.IPublicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPublicacionServicioImpl extends ICRUDimpl <Publicacion,Integer> implements IPublicacionServicio {
    @Autowired
    private IPublicacionRepositorio repositorio;
    @Override
    protected IGeneralRepositorio<Publicacion, Integer> getRepo() {
        return repositorio ;
    }
}
