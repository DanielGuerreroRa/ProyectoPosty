package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.modelo.Historia;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IHistoriaRepositorio;
import com.corenetworks.ProyectoFinal.servicio.IHistoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IHistoriaServicioImpl extends ICRUDimpl <Historia, Integer> implements IHistoriaServicio {
    @Autowired
    private IHistoriaRepositorio repositorio;
    @Override
    protected IGeneralRepositorio<Historia, Integer> getRepo() {
        return repositorio;
    }


    @Override
    public List<Historia> HistoriasVisiblesPorSeguidor(int idPropietario) {
        return repositorio.HistoriasVisiblesPorSeguidor(idPropietario);
    }

    @Override
    public List<Historia> HistoriasPaTodos(int idPropietario) {
        return repositorio.HistoriasPaTodos(idPropietario);
    }


}
