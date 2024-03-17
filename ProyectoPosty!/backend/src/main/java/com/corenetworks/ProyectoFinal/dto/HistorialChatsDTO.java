package com.corenetworks.ProyectoFinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistorialChatsDTO {
    private int idMensaje;
    private String contenido;
    private LocalDate fCreacion;
    private LocalTime hCreacion;
    private String urlFotos;
    private String nombreUsuarioOrigen;
    private String nombreUsuarioDestino;
    private String FotoPerfilOrigen;
    private String FotoPerfilDestino;

}
