package com.corenetworks.ProyectoFinal.dto;

import com.corenetworks.ProyectoFinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BuscarPorNombreDTO extends Usuario {
    private String nombreUsuario;
}
