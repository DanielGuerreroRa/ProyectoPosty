package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.dto.BarritaDeMensajesDto;
import com.corenetworks.ProyectoFinal.dto.HistorialChatsDTO;
import com.corenetworks.ProyectoFinal.dto.MensajeDTO;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;

import java.util.List;

public interface IMensajeServicio extends ICRUD <Mensaje, Integer> {
    List<MensajeDTO> filtroMensajesporId(int id) throws Exception;
    Mensaje enviarMensaje (Mensaje mensaje);

    List<HistorialChatsDTO> historialChats(int id_origen, int id_destino) throws Exception;

    List<BarritaDeMensajesDto> barritaDeMensajes(int id_origen) throws Exception;
}
