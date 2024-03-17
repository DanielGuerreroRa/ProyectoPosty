package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.CantidadSeguidoresDTO;
import com.corenetworks.ProyectoFinal.dto.SeguidorDTO;
import com.corenetworks.ProyectoFinal.dto.views;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.ISeguidorServicio;
import com.corenetworks.ProyectoFinal.servicio.IUsuarioServicio;
import com.corenetworks.ProyectoFinal.servicio.Impl.IUsuarioServicioimpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/seguidores")
@CrossOrigin(origins = "http://localhost:4200")
public class SeguidorControlador{
    @Autowired
    ISeguidorServicio seguidorServicio;
    @Autowired
    IUsuarioServicio usuarioServicioimpl;
    @GetMapping("/usuario/{idUsuario}/seguidores")
    public ResponseEntity<List<SeguidorDTO>> obtenerSeguidores(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.ok(seguidorServicio.obtenerSeguidores(usuarioServicioimpl.buscarPorId(idUsuario)));
    }

    @GetMapping("/usuario/{idUsuario}/seguidos")
    public ResponseEntity<List<SeguidorDTO>> obtenerSeguidos(@PathVariable int idUsuario) throws Exception {
        return ResponseEntity.ok(seguidorServicio.obtenerSeguidos(usuarioServicioimpl.buscarPorId(idUsuario)));
    }
    @JsonView(views.Public.class)
    @PostMapping("/seguir/{idSeguidor}/{idSeguido}")
    public ResponseEntity<String> seguirUsuario(@PathVariable int idSeguidor, @PathVariable int idSeguido) {
        try {
            Usuario seguidor = usuarioServicioimpl.buscarPorId(idSeguidor);
            Usuario seguido = usuarioServicioimpl.buscarPorId(idSeguido);
            List<SeguidorDTO> seguidores = seguidorServicio.obtenerSeguidores(seguido);
            boolean yaSigue = false;

            if (seguidor == null || seguido == null) {
                return ResponseEntity.badRequest().body("No existe la id del seguidor o la id del seguido");
            }

            if (seguidor.getIdUsuario() == seguido.getIdUsuario()) {
                return ResponseEntity.badRequest().body("El usuario no puede seguirse a sí mismo");
            }

            for (SeguidorDTO seguidorDTO : seguidores) {
                if (Objects.equals(seguidorDTO.getNombreUsuarioSeguidor(), seguidor.getNombreUsuario())) {
                    yaSigue = true;
                    break;
                }
            }

            if (yaSigue) {
                return ResponseEntity.badRequest().body("El usuario ya sigue a este");
            }

            seguidorServicio.seguirUsuario(idSeguidor, idSeguido);
            return ResponseEntity.ok("Se ha seguido al usuario correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar seguir al usuario: " + e.getMessage());
        }
    }

    @GetMapping("/total/seguidores/{usuario}")
    public ResponseEntity<List<CantidadSeguidoresDTO>> cantidadeSeguidores(@PathVariable("usuario")String NombreUsuario){
        return new ResponseEntity<>(seguidorServicio.seguidor(NombreUsuario),HttpStatus.OK);
    }

    @GetMapping("/total/seguidos/{usuario}")
    public ResponseEntity<List<CantidadSeguidoresDTO>> cantidadeSeguidos(@PathVariable("usuario")String NombreUsuario){
        return new ResponseEntity<>(seguidorServicio.seguidos(NombreUsuario),HttpStatus.OK);
    }
}
