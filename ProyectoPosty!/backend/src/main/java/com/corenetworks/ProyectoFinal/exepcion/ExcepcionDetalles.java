package com.corenetworks.ProyectoFinal.exepcion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExcepcionDetalles {
    private LocalDateTime fecha;
    private String mensaje;
    private String descripcion;
}
