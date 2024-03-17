
package com.corenetworks.ProyectoFinal.modelo;
import com.corenetworks.ProyectoFinal.dto.views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "perfil")
public class Perfil{
    @JsonView(views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPerfil;
    @JsonView(views.Public.class)
    private String nombre;
    @JsonView(views.Public.class)
    private String apellido;
    @JsonView(views.Public.class)
    private int numSeguidores;
    @JsonView(views.Public.class)
    private int numSiguiendo;
    @JsonView(views.Public.class)
    private int numPublicaciones;
    @JsonView(views.Public.class)
    private String fotoPerfil;
    @JsonView(views.Public.class)
    @Column(length = 250)
    private String descripcion;

    @JsonView(views.Public.class)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_perfil_usuario"))
    private Usuario usuario;

}

