package com.corenetworks.ProyectoFinal.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "seguidores")
public class Seguidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario_seguidor")
    private Usuario seguidor;

    @ManyToOne
    @JoinColumn(name = "id_usuario_seguido")
    private Usuario seguido;
}
