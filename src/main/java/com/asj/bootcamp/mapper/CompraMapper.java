package com.asj.bootcamp.mapper;

import com.asj.bootcamp.dto.CompraDTO;
import com.asj.bootcamp.entity.Compra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompraMapper {

    CompraDTO compraEntityToCompraDTO(Compra compra);
    Compra compraDTOToEntity(CompraDTO compraDTO);

}