package com.corenetworks.ProyectoFinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BarritaDeMensajesDto {

    private String contenido;
    private String urlFotos;
    private String nombreUsuarioDestino;
    private String fotoPerfilDestino;
    private LocalDate fCreacion;
    private LocalTime hCreacion;

}
