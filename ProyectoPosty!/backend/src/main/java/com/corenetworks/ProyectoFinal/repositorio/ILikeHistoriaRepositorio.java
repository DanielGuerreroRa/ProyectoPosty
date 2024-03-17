package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.modelo.LikeHistoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ILikeHistoriaRepositorio extends IGeneralRepositorio<LikeHistoria,Integer> {
    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN true ELSE false END " +
            "FROM LikeHistoria l " +
            "WHERE l.usuario.idUsuario = :idUsuario " +
            "AND l.historia.idHistoria = :idHistoria")
    boolean dioLikeH(@Param("idUsuario") int idUsuario, @Param("idHistoria") int idHistoria);

    @Query("SELECT COUNT(id) FROM LikeHistoria l WHERE l.historia.idHistoria = :idHistoria")
    int cantidadDeLikesH(@Param("idHistoria") int idHistoria);
}
