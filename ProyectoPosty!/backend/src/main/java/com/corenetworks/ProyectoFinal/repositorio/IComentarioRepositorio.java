package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.dto.ComentarioDTO;
import com.corenetworks.ProyectoFinal.modelo.Comentario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IComentarioRepositorio extends IGeneralRepositorio <Comentario, Integer> {
    @Query("SELECT NEW com.corenetworks.ProyectoFinal.dto.ComentarioDTO(" +
            "c.idComentario, c.likes,c.mensajes,c.publicacion.idPublicacion,c.publicacion.usuario.nombreUsuario,c.publicacion.usuario.fotoPerfil,c.usuario.nombreUsuario ,c.usuario.fotoPerfil ,c.usuario.idUsuario,c.fCreacion, c.hCreacion) " +
            "FROM Comentario c " +
            "WHERE c.idComentario = :idComentario")
ComentarioDTO mostrarComentario(@Param("idComentario") int idComentario);
}
