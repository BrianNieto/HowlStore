package com.asj.bootcamp.dto;

import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.entity.User;

import java.time.LocalDate;


public class CompraDTO {

    Integer idCompra;
    String comentario;
    LocalDate fecha;
    String estadoPedido;
    Item item;
    User user;

}