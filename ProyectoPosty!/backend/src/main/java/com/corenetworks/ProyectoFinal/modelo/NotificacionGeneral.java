package com.corenetworks.ProyectoFinal.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "notificaciones")
public class NotificacionGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    private LocalDate fNotificacion;
    private Character tipoNotificacion;
    private LocalTime hNotificacion;

    /*
     * A: Amistad
     * L: Likes en publicacion/comentario
     * T: Etiquetado en publicación
     * C: Nuevos comentarios en publicaciones
     */

    @ManyToOne
    @JoinColumn(name = "usuarioOrigen_id")
    private Usuario usuarioOrigen;

    @ManyToOne
    @JoinColumn(name = "usuarioDestino_id")
    private Usuario usuarioDestino;

}
