package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.dto.CantidadSeguidoresDTO;
import com.corenetworks.ProyectoFinal.dto.HistoriaPrivadaDTO;
import com.corenetworks.ProyectoFinal.modelo.Historia;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IHistoriaRepositorio extends IGeneralRepositorio <Historia,Integer> {

    @Query("SELECT h FROM Historia h " +
            "WHERE h.usuario.id = :idUsuario " +
            "AND h.Activo = true")
    List<Historia> HistoriasVisiblesPorSeguidor(int idUsuario);

    @Query("SELECT h FROM Historia h " +
            "WHERE h.usuario.id = :idUsuario " +
            "AND h.Activo = true " +
            "AND h.publicas = true")
    List<Historia> HistoriasPaTodos(int idUsuario);


}
