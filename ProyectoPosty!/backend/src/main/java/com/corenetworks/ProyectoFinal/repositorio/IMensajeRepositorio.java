package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.dto.BarritaDeMensajesDto;
import com.corenetworks.ProyectoFinal.dto.HistorialChatsDTO;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMensajeRepositorio extends IGeneralRepositorio<Mensaje, Integer>{
 @Query(value = "Select m.id_mensaje,m.contenido,m.f_creacion,m.h_creacion,m.url_fotos,u.nombre_usuario,d.nombre_usuario \n" +
         "from mensajes m \n" +
         "inner join usuarios u\n" +
         "on u.id_usuario= m.usuario_origen_id\n" +
         "inner join usuarios d\n" +
         "on d.id_usuario= m.usuario_destino_id\n" +
         "where usuario_origen_id=:id",nativeQuery = true)
 List<Object[]> filtroMensajesPoridUsuario(@Value("id") int id) throws Exception;
 @Query("SELECT NEW com.corenetworks.ProyectoFinal.dto.HistorialChatsDTO(" +
         "m.idMensaje, " +
         "m.contenido, " +
         "m.fCreacion, " +
         "m.hCreacion, " +
         "m.urlFotos, " +
         "CASE " +
         "    WHEN m.usuarioOrigen.idUsuario = :id_origen THEN m.usuarioOrigen.nombreUsuario " +
         "    ELSE m.usuarioDestino.nombreUsuario " +
         "END AS nombreRemitente, " +
         "CASE " +
         "    WHEN m.usuarioOrigen.idUsuario = :id_origen THEN m.usuarioOrigen.fotoPerfil " +
         "    ELSE m.usuarioDestino.fotoPerfil " +
         "END AS fotoPerfilRemitente, " +
         "CASE " +
         "    WHEN m.usuarioOrigen.idUsuario = :id_origen THEN m.usuarioDestino.nombreUsuario " +
         "    ELSE m.usuarioOrigen.nombreUsuario " +
         "END AS nombreDestinatario, " +
         "CASE " +
         "    WHEN m.usuarioOrigen.idUsuario = :id_origen THEN m.usuarioDestino.fotoPerfil " +
         "    ELSE m.usuarioOrigen.fotoPerfil " +
         "END AS fotoPerfilDestinatario) " +
         "FROM Mensaje m " +
         "JOIN m.usuarioOrigen uo " +
         "JOIN m.usuarioDestino ud " +
         "WHERE (uo.idUsuario = :id_origen AND ud.idUsuario = :id_destino) OR (uo.idUsuario = :id_destino AND ud.idUsuario = :id_origen) " +
         "ORDER BY m.fCreacion, m.hCreacion")
 List<HistorialChatsDTO> historialChats(@Param("id_origen")int id_Origen, @Param("id_destino")int id_Destino) throws Exception;

 @Query("SELECT NEW com.corenetworks.ProyectoFinal.dto.BarritaDeMensajesDto(" +
         "m.contenido, m.urlFotos, m.usuarioDestino.nombreUsuario, m.usuarioDestino.fotoPerfil, m.fCreacion, m.hCreacion) " +
         "FROM Mensaje m " +
         "WHERE (m.idMensaje, m.usuarioOrigen.idUsuario) IN " +
         "(SELECT MAX(m2.idMensaje), m2.usuarioOrigen.idUsuario " +
         "FROM Mensaje m2 " +
         "WHERE m2.usuarioDestino.idUsuario = :idUsuario OR m2.usuarioOrigen.idUsuario = :idUsuario " +
         "GROUP BY m2.usuarioOrigen.idUsuario) " +
         "ORDER BY m.fCreacion, m.hCreacion")
 List<BarritaDeMensajesDto> barritadeMensajes(@Param("idUsuario")int id) throws Exception;
}
