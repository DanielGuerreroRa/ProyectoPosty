package com.corenetworks.ProyectoFinal.modelo;

import java.time.LocalDate;

import com.corenetworks.ProyectoFinal.dto.views;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "publicaciones")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPublicacion")
public class Publicacion {
    @JsonView(views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicacion;
    @JsonView(views.Public.class)
    private String descripcion;
    @JsonView(views.Public.class)
    private int cantidadLikes;

    @JsonView(views.Public.class)
    @Column(columnDefinition = "TEXT")
    private String rutaContenido;

    @JsonView(views.Public.class)
    private String urlCompartir;
    @JsonView(views.Private.class)
    //private String guardar;
    private LocalDate fCreacion;
    @JsonView(views.Private.class)
    private LocalTime hCreacion;

    // Comentario
    @JsonView(views.Public.class)
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_publicacion")) // adjust the column name
    private Usuario usuario;

    @JsonView(views.Public.class)
    @OneToMany(mappedBy = "publicacion")
    private List<Comentario> comentarios;





}
