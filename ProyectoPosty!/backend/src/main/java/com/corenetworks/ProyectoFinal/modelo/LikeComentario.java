package com.corenetworks.ProyectoFinal.modelo;

import com.corenetworks.ProyectoFinal.dto.views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "likesC")
public class LikeComentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonView(views.Public.class)
    @ManyToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;
    @JsonView(views.Public.class)
    @ManyToOne
    @JoinColumn(name = "id_Comentario")
    private Comentario Comentario;
}
