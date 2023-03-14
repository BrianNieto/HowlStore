package com.asj.bootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class CompraDTO {

    String comentario;
    String estadoPedido;
    Integer idItem;
    Integer idUser;

}