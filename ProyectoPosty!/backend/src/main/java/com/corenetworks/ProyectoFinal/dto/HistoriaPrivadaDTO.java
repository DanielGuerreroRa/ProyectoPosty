package com.corenetworks.ProyectoFinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoriaPrivadaDTO {
    private int idHistoria;
    private String contenido;
    private Boolean publicas;
    private LocalDate fCreacion;
    private LocalTime hCreacion;
    private String nombreUsuario;
}
