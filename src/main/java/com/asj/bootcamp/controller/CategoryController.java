package com.asj.bootcamp.controller;

import com.asj.bootcamp.dto.CategoryDTO;
import com.asj.bootcamp.dto.ItemDTO;
import com.asj.bootcamp.entity.Category;
import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.exception.NotFoundException;
import com.asj.bootcamp.mapper.CategoryMapper;
import com.asj.bootcamp.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryController {

    private CategoryService service;

    private CategoryMapper mapper;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        Category category = mapper.categoryDTOToCategoryEntity(categoryDTO);
        CategoryDTO tmp = mapper.categoryEntityToCategoryDTO(service.createCategory(category));
        return ResponseEntity.status(HttpStatus.CREATED).body(tmp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Integer id){
        try {
            Category category =  service.getCategory(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.categoryEntityToCategoryDTO(category));
        }
        catch (NotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria no encontrada");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO){
        try {
            Category tmp = mapper.categoryDTOToCategoryEntity(categoryDTO);
            CategoryDTO updated = mapper.categoryEntityToCategoryDTO(service.updateCategory(id, tmp));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
        }
        catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria no encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        try {
            service.deleteCategory(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria no encontrada");
        }
    }
}