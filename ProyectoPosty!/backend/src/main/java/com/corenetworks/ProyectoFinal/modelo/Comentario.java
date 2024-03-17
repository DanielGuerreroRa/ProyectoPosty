package com.corenetworks.ProyectoFinal.modelo;
import com.corenetworks.ProyectoFinal.dto.views;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "comentarios")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idComentario")
public class Comentario {
    @JsonView(views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;
    @JsonView(views.Public.class)
    private int likes;
    @JsonView(views.Public.class)
    private String mensajes;
    @JsonView(views.Public.class)
    private String respuestasUsuarios;
    @JsonView(views.Public.class)
    private LocalDate fCreacion;
    @JsonView(views.Public.class)
    private LocalTime hCreacion;

    @JsonView(views.Public.class)
    @ManyToOne
    @JoinColumn(name = "id_usuario",foreignKey = @ForeignKey(name = "FK_comentarios_usuarios"))
    private Usuario usuario;
    @JsonView(views.Public.class)
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_publicacion",foreignKey = @ForeignKey(name = "FK_comentarios_publicacion"))
    private Publicacion publicacion;



}
