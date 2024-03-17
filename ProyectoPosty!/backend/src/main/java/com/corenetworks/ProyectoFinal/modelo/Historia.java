package com.corenetworks.ProyectoFinal.modelo;
import com.corenetworks.ProyectoFinal.dto.views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "historias")
public class Historia {
    @JsonView(views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistoria;
    @JsonView(views.Public.class)
    private String contenido;
    private Boolean publicas;
    private Boolean Activo;
    @JsonView(views.Public.class)
    private LocalDate fCreacion;
    @JsonView(views.Public.class)
    private LocalTime hCreacion;
    @JsonView(views.Public.class)
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_historias_usuario"))
    private Usuario usuario;



//    private List<Usuario> listaAutorizados;
//
//    private List<Usuario> listaExcluidos;
//
}
