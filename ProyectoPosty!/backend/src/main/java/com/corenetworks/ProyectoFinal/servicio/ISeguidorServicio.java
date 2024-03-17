package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.dto.CantidadSeguidoresDTO;
import com.corenetworks.ProyectoFinal.dto.SeguidorDTO;
import com.corenetworks.ProyectoFinal.modelo.Seguidor;
import com.corenetworks.ProyectoFinal.modelo.Usuario;

import java.util.List;

public interface ISeguidorServicio extends ICRUD<Seguidor,Long> {
    List<SeguidorDTO> obtenerSeguidores(Usuario seguido);
    void seguirUsuario(int idSeguidor, int idSeguido);

    List<CantidadSeguidoresDTO> seguidor(String nombreUsuario);

    List<CantidadSeguidoresDTO> seguidos(String nombreUsuario);
    List<SeguidorDTO> obtenerSeguidos(Usuario seguidor);
    boolean isSeguidor(int idSeguido, int idSeguidor);



}
