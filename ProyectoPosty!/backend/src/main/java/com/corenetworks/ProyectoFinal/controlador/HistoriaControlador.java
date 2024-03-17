package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.views;
import com.corenetworks.ProyectoFinal.exepcion.ExcepcionPersonalizada;
import com.corenetworks.ProyectoFinal.modelo.Historia;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/historias")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoriaControlador {
    @Autowired
    IHistoriaServicio servicio;
    @Autowired
    ISeguidorServicio seServicio;
    @Autowired
    IUsuarioServicio uServicio;

    @Autowired
    ILikeHistoriaServicio hServicio;

    /*
    TODO: Eliminar fecha final
    TODO: Añadir validaciones a las peticiones
    *   */

    @JsonView(views.Public.class)
    @PostMapping("/publicas")
    public ResponseEntity<Historia> subirHistoriaPublica(@PathVariable("usuario") int usuario, @RequestBody Historia h) throws Exception {
        Usuario u1= uServicio.buscarPorId(usuario);
        if (u1==null){
            throw new ExcepcionPersonalizada("El usuario con el id: " + usuario + " no existe");
        }
        h.setActivo(true);
        h.setHCreacion(LocalTime.now());
        h.setFCreacion(LocalDate.now());
        h.getUsuario().setIdUsuario(usuario);
        h.setPublicas(true);
        return new ResponseEntity<>(servicio.crear(h), HttpStatus.CREATED);
    }
    @JsonView(views.Public.class)
    @PostMapping("/privadas")
    public ResponseEntity<Historia> subirHistoriaPrivada(@PathVariable("usuario") int usuario, @RequestBody Historia h) throws Exception {
        Usuario u1= uServicio.buscarPorId(usuario);
        if (u1==null){
            throw new ExcepcionPersonalizada("El usuario con el id: " + usuario + " no existe");
        }
        h.setActivo(true);
        h.setHCreacion(LocalTime.now());
        h.setFCreacion(LocalDate.now());
        h.getUsuario().setIdUsuario(usuario);
        h.setPublicas(false);
        return new ResponseEntity<>(servicio.crear(h), HttpStatus.CREATED);
    }

    //Mañana hacer que el ver en publicas o privadas

    @JsonView(views.Public.class)
    @GetMapping("/de/{idPropietario}/{idSeguidor}")
    public ResponseEntity<List<Historia>> HistoriaVisiblePorSeguidor(@PathVariable("idPropietario") int idPropietario, @PathVariable("idSeguidor") int idSeguidor) throws Exception {
        try {
            Usuario u1= uServicio.buscarPorId(idPropietario);
            Usuario uD= uServicio.buscarPorId(idSeguidor);
            if (u1==null){
                throw new ExcepcionPersonalizada("El usuario con el id: " + idPropietario + " no existe");
            } else if (uD==null) {
                throw new ExcepcionPersonalizada("El usuario con el id: " + idSeguidor + " no existe");
            }
            if (seServicio.isSeguidor(idSeguidor, idPropietario) == false) {
                List<Historia> historiapaTodos = servicio.HistoriasPaTodos(idPropietario);
                return new ResponseEntity<>(historiapaTodos,HttpStatus.OK);
            }
            List<Historia> historiavisible = servicio.HistoriasVisiblesPorSeguidor(idPropietario);
            return new ResponseEntity<>(historiavisible, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}



