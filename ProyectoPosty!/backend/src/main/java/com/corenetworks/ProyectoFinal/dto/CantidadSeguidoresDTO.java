package com.corenetworks.ProyectoFinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CantidadSeguidoresDTO {
    private String NombreUsuario;
    private String fotoperfil;
    private long cantidadSeguidores;
}
