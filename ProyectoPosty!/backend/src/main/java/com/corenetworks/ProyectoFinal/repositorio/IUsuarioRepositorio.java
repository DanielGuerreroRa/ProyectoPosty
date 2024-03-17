package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.dto.BuscarPorNombreDTO;
import com.corenetworks.ProyectoFinal.dto.SeguidorDTO;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsuarioRepositorio extends IGeneralRepositorio<Usuario,Integer> {

@Query(value = "select NEW com.corenetworks.ProyectoFinal.dto.BuscarPorNombreDTO(u.nombreUsuario) from Usuario u where u.nombreUsuario = :nombreUsuario")
BuscarPorNombreDTO BuscarporNombreUsuario(@Param("nombreUsuario") String nombreUsuario);
}


