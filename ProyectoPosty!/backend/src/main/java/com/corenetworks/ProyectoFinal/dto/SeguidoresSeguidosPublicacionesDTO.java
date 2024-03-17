package com.corenetworks.ProyectoFinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeguidoresSeguidosPublicacionesDTO {
    private long seguidores;
    private long seguidos;
    private long Publicaciones;
}
