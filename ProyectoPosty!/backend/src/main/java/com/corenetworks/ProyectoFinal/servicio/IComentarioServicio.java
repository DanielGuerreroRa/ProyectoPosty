package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.dto.ComentarioDTO;
import com.corenetworks.ProyectoFinal.modelo.Comentario;
import com.corenetworks.ProyectoFinal.modelo.Publicacion;

public interface IComentarioServicio extends ICRUD<Comentario, Integer>{
    Comentario enviarComentario(Comentario comentario);

    ComentarioDTO verComentario(int idComentario);
}
