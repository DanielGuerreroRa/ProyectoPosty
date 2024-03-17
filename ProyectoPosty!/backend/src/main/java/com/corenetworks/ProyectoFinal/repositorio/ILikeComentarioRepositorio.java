package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.modelo.LikeComentario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ILikeComentarioRepositorio extends IGeneralRepositorio<LikeComentario,Integer> {
    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN true ELSE false END " +
            "FROM LikeComentario l " +
            "WHERE l.usuario.idUsuario = :idUsuario " +
            "AND l.Comentario.idComentario = :idComentario")
    boolean dioLikeC(@Param("idUsuario") int idUsuario, @Param("idComentario") int idComentario);

    @Query("SELECT COUNT(id) FROM LikeComentario l WHERE l.Comentario.idComentario = :idComentario")
    int cantidadDeLikesC(@Param("idComentario") int idComentario);
}
