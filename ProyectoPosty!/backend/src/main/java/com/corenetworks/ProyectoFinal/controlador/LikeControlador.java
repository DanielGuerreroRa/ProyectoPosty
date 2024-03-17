package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.views;
import com.corenetworks.ProyectoFinal.modelo.*;
import com.corenetworks.ProyectoFinal.repositorio.ILikeHistoriaRepositorio;
import com.corenetworks.ProyectoFinal.servicio.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/like")
@CrossOrigin(origins = "http://localhost:4200")
public class LikeControlador {
    @Autowired
    ILikePublicacionServicio likePublicacionServicio;
    @Autowired
    ILikeComentarioServicio likeComentarioServicio;
    @Autowired
    ILikeHistoriaServicio likeHistoriaServicio;
    @Autowired
    IUsuarioServicio usuarioServicio;
    @Autowired
    IPublicacionServicio publicacionServicio;
    @Autowired
    IComentarioServicio comentarioServicio;
    @Autowired
    IHistoriaServicio historiaServicio;

    @JsonView(views.Public.class)
    @PostMapping("/publicacion/{idPublicacion}/de/{idUsuario}")
    ResponseEntity<LikePublicacion> darLikePublicacion(@PathVariable("idUsuario") int idUsuario, @PathVariable("idPublicacion") int idPublicacion, @RequestBody LikePublicacion likePublicacion) throws Exception {
        if (likePublicacionServicio.dioLikeP(idUsuario,idPublicacion)==true){
            throw new Exception("Ya le has dado like");
        }
        Usuario usuario = usuarioServicio.buscarPorId(idUsuario);
        likePublicacion.setUsuario(usuario);
        Publicacion publicacion= publicacionServicio.buscarPorId(idPublicacion);
        likePublicacion.setPublicacion(publicacion);

        return new ResponseEntity<>(likePublicacionServicio.crear(likePublicacion), HttpStatus.OK);
    }
    @JsonView(views.Public.class)
    @PostMapping("/comentario/{idComentario}/de/{idUsuario}")
    ResponseEntity<LikeComentario> darLikeComentario(@PathVariable("idUsuario") int idUsuario, @PathVariable("idComentario") int idComentario, @RequestBody LikeComentario likeComentario) throws Exception {
        if (likeComentarioServicio.dioLikeC(idUsuario,idComentario)==true){
            throw new Exception("Ya le has dado like");
        }
        Usuario usuario = usuarioServicio.buscarPorId(idUsuario);
        likeComentario.setUsuario(usuario);
        Comentario Comentario= comentarioServicio.buscarPorId(idComentario);
        likeComentario.setComentario(Comentario);

        return new ResponseEntity<>(likeComentarioServicio.crear(likeComentario), HttpStatus.OK);
    }
    @JsonView(views.Public.class)
    @PostMapping("/historia/{idHistoria}/de/{idUsuario}")
    ResponseEntity<LikeHistoria> darLikeHistoria(@PathVariable("idUsuario") int idUsuario, @PathVariable("idHistoria") int idHistoria, @RequestBody LikeHistoria likeHistoria) throws Exception {
        if (likeHistoriaServicio.dioLikeH(idUsuario,idHistoria)==true){
            throw new Exception("Ya le has dado like");
        }
        Usuario usuario = usuarioServicio.buscarPorId(idUsuario);
        likeHistoria.setUsuario(usuario);
        Historia historia= historiaServicio.buscarPorId(idHistoria);
        likeHistoria.setHistoria(historia);

        return new ResponseEntity<>(likeHistoriaServicio.crear(likeHistoria), HttpStatus.OK);
    }
@DeleteMapping("/eliminar/publicacion/{idPublicacion}/de/{idUsuario}")
    ResponseEntity<Void> disLikePublicacion(@PathVariable("idUsuario") int idUsuario, @PathVariable("idPublicacion") int idPublicacion, @RequestBody LikePublicacion likePublicacion) throws Exception {
        if (likePublicacionServicio.dioLikeP(idUsuario,idPublicacion)==false){
            throw new Exception("Ni le has dado like Kbron");
        }
        Usuario usuario = usuarioServicio.buscarPorId(idUsuario);
        likePublicacion.setUsuario(usuario);
        Publicacion publicacion= publicacionServicio.buscarPorId(idPublicacion);
        likePublicacion.setPublicacion(publicacion);
        likePublicacionServicio.eliminar(likePublicacion);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/eliminar/comentario/{idComentario}/de/{idUsuario}")
    ResponseEntity<Void> disLikeComentario(@PathVariable("idUsuario") int idUsuario, @PathVariable("idComentario") int idComentario, @RequestBody LikeComentario likeComentario) throws Exception {
        if (likeComentarioServicio.dioLikeC(idUsuario, idComentario) == false) {
            throw new Exception("Ni le has dado like Kbron");
        }
        Usuario usuario = usuarioServicio.buscarPorId(idUsuario);
        likeComentario.setUsuario(usuario);
        Comentario Comentario = comentarioServicio.buscarPorId(idComentario);
        likeComentario.setComentario(Comentario);
        likeComentarioServicio.editar(likeComentario);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping("/eliminar/historia/{idHistoria}/de/{idUsuario}")
    ResponseEntity<Void> disLikeHistoria(@PathVariable("idUsuario") int idUsuario, @PathVariable("idHistoria") int idHistoria, @RequestBody LikeHistoria likeHistoria) throws Exception {
        if (likeHistoriaServicio.dioLikeH(idUsuario,idHistoria)==false){
            throw new Exception("Ni le has dado like cabron");
        }
        Usuario usuario = usuarioServicio.buscarPorId(idUsuario);
        likeHistoria.setUsuario(usuario);
        Historia historia= historiaServicio.buscarPorId(idHistoria);
        likeHistoria.setHistoria(historia);
        likeHistoriaServicio.eliminar(likeHistoria);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
