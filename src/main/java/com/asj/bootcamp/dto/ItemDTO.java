package com.asj.bootcamp.dto;

import com.asj.bootcamp.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemDTO {

    Integer idItem;
    String nombreItem;
    Integer precioItem;
    Integer stockItem;
    String estadoItem;
    Categoria categoria;

}