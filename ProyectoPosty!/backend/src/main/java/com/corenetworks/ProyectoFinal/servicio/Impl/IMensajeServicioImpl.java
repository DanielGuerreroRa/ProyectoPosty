package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.dto.BarritaDeMensajesDto;
import com.corenetworks.ProyectoFinal.dto.HistorialChatsDTO;
import com.corenetworks.ProyectoFinal.dto.MensajeDTO;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IMensajeRepositorio;
import com.corenetworks.ProyectoFinal.servicio.IMensajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class IMensajeServicioImpl extends ICRUDimpl <Mensaje, Integer> implements IMensajeServicio {
    @Autowired
    private IMensajeRepositorio repositorio;


    @Override
    protected IGeneralRepositorio<Mensaje,Integer> getRepo() {
        return repositorio;
    }

    @Override
    public List<MensajeDTO> filtroMensajesporId(int id) throws Exception {
        List <MensajeDTO> mDTO= new ArrayList<>();
        List<Object[]> resultado= repositorio.filtroMensajesPoridUsuario(id);
        for (Object[] elemento:
             resultado) {
            MensajeDTO m= new MensajeDTO();
            m.setIdMensaje((Integer) elemento[0]);
            m.setContenido((String) elemento[1]);
            m.setFCreacion(((java.sql.Date) elemento[2]).toLocalDate());
            m.setHCreacion(((java.sql.Time) elemento[3]).toLocalTime());
            m.setUrlFotos((String) elemento[4]);
            m.setNombreUsuarioOrigen((String) elemento[5]);
            m.setNombreUsuarioDestino((String) elemento[6]);
            mDTO.add(m);

        }
        return mDTO;
    }


    @Override
    public Mensaje enviarMensaje(Mensaje mensaje) {
        return repositorio.save(mensaje);
    }

    @Override
    public List<HistorialChatsDTO> historialChats(int id_origen, int id_destino) throws Exception{
        return repositorio.historialChats(id_origen,id_destino);
    }

    @Override
    public List<BarritaDeMensajesDto> barritaDeMensajes(int id_origen) throws Exception {
        return repositorio.barritadeMensajes(id_origen);
    }

}
