package com.asj.bootcamp.mapper;

import com.asj.bootcamp.dto.CategoryDTO;
import com.asj.bootcamp.dto.ItemDTO;
import com.asj.bootcamp.entity.Category;
import com.asj.bootcamp.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO categoryEntityToCategoryDTO(Category category);

    Category categoryDTOToCategoryEntity(CategoryDTO categoryDTO);

}