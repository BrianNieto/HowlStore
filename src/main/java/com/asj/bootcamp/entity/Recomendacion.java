package com.asj.bootcamp.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "recomendaciones")
@AllArgsConstructor
@NoArgsConstructor
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idRecomendacion;
    @Column(nullable = false)
    String nombre;
    @Column(nullable = false)
    String comentario;
    @Column(nullable = false)
    LocalDate fechaRecomendacion;
    @Column(nullable = false)
    String img;

}