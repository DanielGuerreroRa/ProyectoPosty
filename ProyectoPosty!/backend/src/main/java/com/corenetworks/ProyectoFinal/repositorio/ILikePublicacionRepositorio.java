package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.modelo.LikePublicacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILikePublicacionRepositorio extends IGeneralRepositorio<LikePublicacion,Integer> {
    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN true ELSE false END " +
            "FROM LikePublicacion l " +
            "WHERE l.usuario.idUsuario = :idUsuario " +
            "AND l.publicacion.idPublicacion = :idPublicacion")
    boolean dioLikeP(@Param("idUsuario") int idUsuario, @Param("idPublicacion") int idPublicacion);

    @Query("SELECT COUNT(id) FROM LikePublicacion l WHERE l.publicacion.idPublicacion = :idPublicacion")
    int cantidadDeLikesP(@Param("idPublicacion") int idPublicacion);


}
