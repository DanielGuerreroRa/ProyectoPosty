package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.dto.CantidadSeguidoresDTO;
import com.corenetworks.ProyectoFinal.dto.PerfilDTO;
import com.corenetworks.ProyectoFinal.dto.SeguidorDTO;
import com.corenetworks.ProyectoFinal.modelo.Seguidor;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.ISeguidorRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IUsuarioRepositorio;
import com.corenetworks.ProyectoFinal.servicio.ISeguidorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ISeguidorServicioimpl extends ICRUDimpl <Seguidor,Long> implements ISeguidorServicio {
    @Autowired
    private ISeguidorRepositorio repositorio;
    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;
    @Override
    protected IGeneralRepositorio<Seguidor, Long> getRepo() {
        return repositorio;
    }
    public List<SeguidorDTO> obtenerSeguidores(Usuario seguido) {
        List<Seguidor> seguidores = repositorio.findBySeguido(seguido);
        List<SeguidorDTO> seguidoresDTO = new ArrayList<>();

        for (Seguidor seguidor : seguidores) {
            SeguidorDTO seguidorDTO = new SeguidorDTO();
            // Mapea los datos del Seguidor a un SeguidorDTO
            seguidorDTO.setId((long) Math.toIntExact(seguidor.getId()));
            seguidorDTO.setNombreUsuarioSeguidor(seguidor.getSeguidor().getNombreUsuario());
            seguidorDTO.setFotoPerfilSeguidor(seguidor.getSeguidor().getFotoPerfil());
            seguidorDTO.setNombreUsuarioSeguido(seguidor.getSeguido().getNombreUsuario());
            seguidorDTO.setFotoPerfilSeguido(seguidor.getSeguido().getFotoPerfil());
            seguidoresDTO.add(seguidorDTO);
        }
        return seguidoresDTO;
    }

    public void seguirUsuario(int idSeguidor, int idSeguido) {
        Usuario seguidor = usuarioRepositorio.findById(idSeguidor).orElse(null);
        Usuario seguido = usuarioRepositorio.findById(idSeguido).orElse(null);

        Seguidor nuevoSeguidor = new Seguidor();
        nuevoSeguidor.setSeguidor(seguidor);
        nuevoSeguidor.setSeguido(seguido);
        repositorio.save(nuevoSeguidor);
    }

    @Override
    public List<CantidadSeguidoresDTO> seguidor(String nombreUsuario) {
        return repositorio.seguidor(nombreUsuario);
    }
    @Override
    public List<CantidadSeguidoresDTO> seguidos(String nombreUsuario) {
        return repositorio.seguidos(nombreUsuario);
    }

    public List<SeguidorDTO> obtenerSeguidos(Usuario seguidor) {
        List<Seguidor> seguidos = repositorio.findBySeguidor(seguidor);
        List<SeguidorDTO> seguidoresDTO = new ArrayList<>();

        for (Seguidor elemento : seguidos) {
            SeguidorDTO seguidorDTO = new SeguidorDTO();
            // Mapea los datos del Seguidor a un SeguidorDTO
            seguidorDTO.setId((long) Math.toIntExact(elemento.getId()));
            seguidorDTO.setNombreUsuarioSeguidor(elemento.getSeguidor().getNombreUsuario());
            seguidorDTO.setFotoPerfilSeguidor(elemento.getSeguidor().getFotoPerfil());
            seguidorDTO.setNombreUsuarioSeguido(elemento.getSeguido().getNombreUsuario());
            seguidorDTO.setFotoPerfilSeguido(elemento.getSeguido().getFotoPerfil());
            seguidoresDTO.add(seguidorDTO);
        }
        return seguidoresDTO;
    }

    @Override
    public boolean isSeguidor(int idSeguido, int idSeguidor) {
        return repositorio.isSeguidor(idSeguidor,idSeguido);
    }


}
