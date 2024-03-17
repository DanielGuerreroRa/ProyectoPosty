package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.dto.SeguidorDTO;
import com.corenetworks.ProyectoFinal.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio extends ICRUD <Usuario,Integer>{
   Usuario BuscarPorNombreUsuario(String nombreUsuario);

}
