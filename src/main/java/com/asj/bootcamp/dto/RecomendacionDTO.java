package com.asj.bootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class RecomendacionDTO {
    Integer idRecomendacion;
    String nombre;
    String comentario;
    LocalDate fechaRecomendacion;
    String img;
}