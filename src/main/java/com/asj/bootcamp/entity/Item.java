package com.asj.bootcamp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    String nombreItem;
    Integer precioItem;
    Integer idCategoria;
    Integer stockItem;
}