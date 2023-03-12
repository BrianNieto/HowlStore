package com.asj.bootcamp.mapper;

import com.asj.bootcamp.dto.ItemDTO;
import com.asj.bootcamp.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDTO itemEntityToItemDTO(Item item);

    Item itemDTOToItemEntity(ItemDTO itemDTO);

}