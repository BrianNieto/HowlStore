package com.asj.bootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemDTO {
    String nombreItem;
    Integer precioItem;
    Integer stockItem;
    String estadoItem;
    String srcItem;
    Integer idCategory;
}