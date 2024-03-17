package com.corenetworks.ProyectoFinal.dto;

import com.corenetworks.ProyectoFinal.modelo.Seguidor;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeguidorDTO {
    private Long id;
    private String NombreUsuarioSeguidor;
    private String fotoPerfilSeguidor;
    private String NombreUsuarioSeguido;
    private String fotoPerfilSeguido;



    public Seguidor castSeguidor(){
        Seguidor s1 = new Seguidor();
        Usuario uSeguido = new Usuario();
        Usuario follower = new Usuario();


        uSeguido.setNombreUsuario(NombreUsuarioSeguido);
        uSeguido.setFotoPerfil(fotoPerfilSeguido);

        follower.setNombreUsuario(NombreUsuarioSeguidor);
        follower.setFotoPerfil(fotoPerfilSeguidor);

        s1.setSeguido(uSeguido);
        s1.setSeguidor(follower);


        return s1;
    }
}
