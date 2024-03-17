package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.Historia;

import java.util.List;

public interface IHistoriaServicio extends ICRUD<Historia,Integer>{

    List<Historia> HistoriasVisiblesPorSeguidor(int idPropietario);

    List<Historia> HistoriasPaTodos(int idPropietario);

}
