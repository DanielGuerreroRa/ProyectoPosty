package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.ComentarioDTO;
import com.corenetworks.ProyectoFinal.dto.views;
import com.corenetworks.ProyectoFinal.exepcion.ExcepcionPersonalizada;
import com.corenetworks.ProyectoFinal.modelo.Comentario;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Publicacion;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.IComentarioServicio;
import com.corenetworks.ProyectoFinal.servicio.IPublicacionServicio;
import com.corenetworks.ProyectoFinal.servicio.IUsuarioServicio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/comentario")
@CrossOrigin(origins = "http://localhost:4200")
public class ComentarioControlador {
    @Autowired
    IComentarioServicio servicio;
    @Autowired
    IPublicacionServicio puServicio;
    @Autowired
    IUsuarioServicio uservicio;

    @Autowired
    IComentarioServicio cServicio;
    @JsonView(views.Public.class)
    @PostMapping("/enviarcomentario/de/{idPublicacion}/de/{idUsuario}")
    ResponseEntity<Comentario> enviarComentario(@PathVariable("idPublicacion") int idPublicacion, @PathVariable("idUsuario") int idUsuario, @RequestBody Comentario comentario) throws Exception {
        Publicacion Publicacion = puServicio.buscarPorId(idPublicacion);
        if (Publicacion == null) {
            throw new ExcepcionPersonalizada("No existe la publicacion");
        }
        comentario.setPublicacion(Publicacion);
        comentario.setUsuario(uservicio.buscarPorId(idUsuario));
        comentario.setLikes(0);
        comentario.setFCreacion(LocalDate.now());
        comentario.setHCreacion(LocalTime.now());
        Comentario comentarioEnviado=servicio.enviarComentario(comentario);
        return new ResponseEntity<>(comentarioEnviado, HttpStatus.CREATED);


    }

    @GetMapping("/{idComentario}")
    ResponseEntity<ComentarioDTO> ver(@PathVariable("idComentario")int id) throws Exception {
        return new ResponseEntity<>(servicio.verComentario(id),HttpStatus.OK);
    }


}
