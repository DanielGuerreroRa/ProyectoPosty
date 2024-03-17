package com.corenetworks.ProyectoFinal.dto;


import com.corenetworks.ProyectoFinal.modelo.Perfil;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PerfilDTO {
    private long idPerfil;
    private String fotoPerfil;
    private String descripcion;
    private String nombreUsuario;
    private String nombre;
    private String Apellido;
}
