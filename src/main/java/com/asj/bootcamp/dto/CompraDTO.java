package com.asj.bootcamp.dto;

import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.entity.User;

import java.util.Date;

public class CompraDTO {

    Integer idCompra;
    String comentario;
    Date fecha;
    String estadoPedido;
    Item item;
    User user;

}