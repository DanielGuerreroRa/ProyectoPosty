package com.corenetworks.ProyectoFinal.modelo;

import com.corenetworks.ProyectoFinal.dto.views;
import com.fasterxml.jackson.annotation.JsonView;
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
@Table(name = "mensajes")
public class Mensaje {
    @JsonView(views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;
    @JsonView(views.Public.class)
    private LocalDate fCreacion;
    @JsonView(views.Public.class)
    @Column(nullable = false)
    private String contenido;
    @JsonView(views.Public.class)
    private String urlFotos;
    @JsonView(views.Public.class)
    private LocalTime hCreacion;

    @JsonView(views.Public.class)
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarioOrigen_id", nullable = false)
    private Usuario usuarioOrigen;

    @JsonView(views.Public.class)
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarioDestino_id", nullable = false)
    private Usuario usuarioDestino;

    @JsonView(views.Public.class)
    @ManyToOne
    @JoinColumn(name = "id_historia",foreignKey = @ForeignKey(name = "FK_comentarios_historia"))
    private Historia historia;
}
