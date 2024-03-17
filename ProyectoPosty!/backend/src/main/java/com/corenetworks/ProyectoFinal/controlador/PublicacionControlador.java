package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.views;
import com.corenetworks.ProyectoFinal.exepcion.ExcepcionPersonalizada;

import com.corenetworks.ProyectoFinal.modelo.Comentario;
import com.corenetworks.ProyectoFinal.modelo.LikePublicacion;
import com.corenetworks.ProyectoFinal.modelo.Publicacion;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.ILikeComentarioServicio;
import com.corenetworks.ProyectoFinal.servicio.ILikePublicacionServicio;
import com.corenetworks.ProyectoFinal.servicio.IPublicacionServicio;
import com.corenetworks.ProyectoFinal.servicio.Impl.IUsuarioServicioimpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/publicaciones")
public class PublicacionControlador {
    @Autowired
    IPublicacionServicio publicacionServicio;
    @Autowired
    IUsuarioServicioimpl usuarioServicioimpl;
    @Autowired
    ILikePublicacionServicio ILikePublicacionServicio;

    @Autowired
    ILikeComentarioServicio ILikeComentarioServicio;
    @JsonView(views.Public.class)
    @GetMapping
    public ResponseEntity <List<Publicacion>> obtenerTodasPublicaciones() throws Exception {
        List<Publicacion> publicaciones = publicacionServicio.buscarTodos();
        for (Publicacion publicacion : publicaciones) {
            int cantidadLikes = ILikePublicacionServicio.cantidadLikeP(publicacion.getUsuario().getIdUsuario());
            publicacion.setCantidadLikes(cantidadLikes);

        List<Comentario> comentarios = publicacion.getComentarios();
        for (Comentario comentario : comentarios) {
            int cantidadLikesComentario = ILikeComentarioServicio.cantidadLikeC(comentario.getIdComentario());
            comentario.setLikes(cantidadLikesComentario);
        }
        }
            return new ResponseEntity<>(publicacionServicio.buscarTodos(), HttpStatus.OK);
        }
    @JsonView(views.Public.class)
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicaconId(@PathVariable int id) throws Exception {
        Publicacion p= publicacionServicio.buscarPorId(id);
        int l= ILikePublicacionServicio.cantidadLikeP(p.getUsuario().getIdUsuario());
        p.setCantidadLikes(l);
        if (p==null){
            throw new ExcepcionPersonalizada("No existe la publicacion con el id "+ id);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    @JsonView(views.Public.class)
    @PostMapping("/{id_usuario}")
    public ResponseEntity<Publicacion> guardarPublicacion(@RequestBody Publicacion publicacion, @PathVariable int id_usuario) throws Exception {
        if(usuarioServicioimpl.buscarPorId(id_usuario) == null) {
            throw new ExcepcionPersonalizada("El usuario con el id: "+id_usuario+" no existe");
        }
        if(publicacion.getDescripcion().isEmpty() || publicacion.getDescripcion().length() < 3){
            throw new ExcepcionPersonalizada("La descripcion no puede estar vacia y debe ser mayor a 3 caracteres");
        }

        Usuario usuario = usuarioServicioimpl.buscarPorId(id_usuario);
        publicacion.setUsuario(usuario);
        int ultimaId = publicacionServicio.buscarTodos().size() + 1;
        publicacion.setIdPublicacion(ultimaId);
        publicacion.setUrlCompartir("http://localhost:3000/api/publicaciones/"+publicacion.getIdPublicacion());
        int l= ILikePublicacionServicio.cantidadLikeP(usuario.getIdUsuario());
        publicacion.setCantidadLikes(l);
        publicacion.setFCreacion(LocalDate.now());
        publicacion.setHCreacion(LocalTime.now());
        publicacion.setCantidadLikes(0);

        return new ResponseEntity<>(publicacionServicio.crear(publicacion),HttpStatus.CREATED);
    }
    @JsonView(views.Public.class)
    @PutMapping
    public ResponseEntity<Publicacion> actualizarPublicacion(@RequestBody Publicacion publicacion) throws Exception {
        return new ResponseEntity<>(publicacionServicio.editar(publicacion),HttpStatus.OK);
    }
}
