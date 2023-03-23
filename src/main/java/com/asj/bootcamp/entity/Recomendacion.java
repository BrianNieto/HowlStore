package com.asj.bootcamp.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recomendaciones")
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idRecomendacion;
    @Column(nullable = false)
    String nombreRecomendacion;
    @Column(nullable = false)
    String comentarioRecomendacion;
    @Column(nullable = false)
    LocalDate fechaRecomendacion;
    @Column(nullable = false)
    String imgRecomendacion;

}