package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.dto.BuscarPorNombreDTO;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.ISeguidorRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IUsuarioRepositorio;
import com.corenetworks.ProyectoFinal.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUsuarioServicioimpl extends ICRUDimpl <Usuario,Integer> implements IUsuarioServicio {
    @Autowired
    private IUsuarioRepositorio repositorio;
    @Autowired
    private ISeguidorRepositorio repositorioS;

    @Override
    protected IGeneralRepositorio<Usuario, Integer> getRepo() {
        return repositorio;
    }


    @Override
    public BuscarPorNombreDTO BuscarPorNombreUsuario(String nombreUsuario) {
        return repositorio.BuscarporNombreUsuario(nombreUsuario);
    }

}