package com.corenetworks.ProyectoFinal.dto;

import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MensajeDTO {
    private int idMensaje;
    private LocalDate fCreacion;
    private String contenido;
    private String urlFotos;
    private LocalTime hCreacion;
    private String nombreUsuarioOrigen;
    private String nombreUsuarioDestino;

    public Mensaje castMensaje(){
        Mensaje m1= new Mensaje();
        Usuario u1= new Usuario();
        m1.setIdMensaje(idMensaje);
        m1.setFCreacion(fCreacion);
        m1.setContenido(contenido);
        m1.setUrlFotos(urlFotos);
        m1.setHCreacion(hCreacion);
        u1.setNombreUsuario(nombreUsuarioOrigen);
        u1.setNombreUsuario(nombreUsuarioDestino);
        return m1;
    }
    public  MensajeDTO castMensajeDTO(Mensaje m){
        idMensaje= m.getIdMensaje();
        fCreacion=m.getFCreacion();
        contenido=m.getContenido();
        urlFotos=m.getUrlFotos();
        hCreacion=m.getHCreacion();
        return this;
    }
    public MensajeDTO castMensajeDTOU(Usuario u){
        nombreUsuarioOrigen= u.getNombreUsuario();
        nombreUsuarioDestino= u.getNombreUsuario();
        return this;
    }
}
