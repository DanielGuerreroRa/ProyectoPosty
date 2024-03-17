package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.dto.PerfilDTO;
import com.corenetworks.ProyectoFinal.dto.SeguidoresSeguidosPublicacionesDTO;
import com.corenetworks.ProyectoFinal.modelo.Perfil;
import org.springframework.data.repository.query.Param;

public interface IPerfilServicio extends ICRUD<Perfil,Long> {
    PerfilDTO datosPerfil(String nombreUsuario) throws Exception;

    SeguidoresSeguidosPublicacionesDTO datos(int idUsuario);


}
