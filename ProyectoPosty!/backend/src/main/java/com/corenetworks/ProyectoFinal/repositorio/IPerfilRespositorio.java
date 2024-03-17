package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.dto.PerfilDTO;
import com.corenetworks.ProyectoFinal.dto.SeguidoresSeguidosPublicacionesDTO;
import com.corenetworks.ProyectoFinal.modelo.Perfil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPerfilRespositorio extends IGeneralRepositorio<Perfil,Long> {
    @Query(value = "SELECT NEW com.corenetworks.ProyectoFinal.dto.PerfilDTO(p.idPerfil, p.fotoPerfil, p.descripcion, p.usuario.nombreUsuario,p.nombre,p.apellido) FROM Perfil p JOIN p.usuario u WHERE u.nombreUsuario= :nombreUsuario")
  PerfilDTO DatosPerfil(@Param("nombreUsuario") String nombreUsuario);


    @Query("SELECT NEW com.corenetworks.ProyectoFinal.dto.SeguidoresSeguidosPublicacionesDTO(" +
            "(SELECT COUNT(s.seguidor) FROM Seguidor s WHERE s.seguido.idUsuario = :idUsuario), " +
            "(SELECT COUNT(s.seguido) FROM Seguidor s WHERE s.seguidor.idUsuario = :idUsuario), " +
            "(SELECT COUNT(p.idPublicacion) FROM Publicacion p WHERE p.usuario.idUsuario = :idUsuario)) " +
            "FROM Usuario u WHERE u.idUsuario = :idUsuario")
    SeguidoresSeguidosPublicacionesDTO datos(@Param("idUsuario") int idUsuario);

}
