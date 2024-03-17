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
@Table(name = "respuestas")
public class RespuestaComentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;
    private int likes;
    private String mensajes;
    private LocalDate fCreacion;
    private LocalTime hCreacion;

    @ManyToOne
    @JoinColumn(name = "id_comentario", nullable = false, foreignKey = @ForeignKey(name = "FK_respuesta_comentario"))
    private Comentario comentario;
}
