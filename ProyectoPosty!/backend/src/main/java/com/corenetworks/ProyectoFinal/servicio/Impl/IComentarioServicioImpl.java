package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.dto.ComentarioDTO;
import com.corenetworks.ProyectoFinal.modelo.Comentario;
import com.corenetworks.ProyectoFinal.repositorio.IComentarioRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.servicio.IComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IComentarioServicioImpl extends ICRUDimpl <Comentario, Integer> implements IComentarioServicio {
    @Autowired
    private IComentarioRepositorio repositorio;

    @Override
    protected IGeneralRepositorio<Comentario, Integer> getRepo() {
        return repositorio;
    }


    @Override
    public Comentario enviarComentario(Comentario comentario) {
        return repositorio.save(comentario);
    }

    @Override
    public ComentarioDTO verComentario(int idComentario) {
        return repositorio.mostrarComentario(idComentario);
    }
}
