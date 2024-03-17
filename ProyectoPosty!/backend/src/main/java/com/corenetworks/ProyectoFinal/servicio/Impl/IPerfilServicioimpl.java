package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.dto.PerfilDTO;
import com.corenetworks.ProyectoFinal.dto.SeguidoresSeguidosPublicacionesDTO;
import com.corenetworks.ProyectoFinal.modelo.Perfil;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IPerfilRespositorio;
import com.corenetworks.ProyectoFinal.servicio.IPerfilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPerfilServicioimpl extends ICRUDimpl<Perfil,Long> implements IPerfilServicio {
    @Autowired
    private IPerfilRespositorio repositorio;
    @Override
    protected IGeneralRepositorio<Perfil, Long> getRepo() {
        return repositorio;
    }


    @Override
    public PerfilDTO datosPerfil(String nombreUsuario)throws Exception {
        PerfilDTO x= repositorio.DatosPerfil(nombreUsuario);
        System.out.println(x);
        return repositorio.DatosPerfil(nombreUsuario);
    }

    @Override
    public SeguidoresSeguidosPublicacionesDTO datos(int idUsuario) {
        return repositorio.datos(idUsuario);
    }
}
