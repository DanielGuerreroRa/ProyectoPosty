package com.corenetworks.ProyectoFinal.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComentarioDTO {

    private int idComentario;
    private int likes;
    private String descripcion;
    private int idPublicacion;
    private String nombreUsuarioPublicacion;
    private String fotoperfilUsuarioPublicacion;
    private String nombreUsuarioComentario;
    private String fotoperfilUsuarioComentario;
    private int idnombreUsuarioComentario;
    private LocalDate fCreacion;
    private LocalTime hCreacion;





}
