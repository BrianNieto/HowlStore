package com.asj.bootcamp.controller;

import com.asj.bootcamp.dto.ItemCompletoDTO;
import com.asj.bootcamp.dto.ItemDTO;
import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.exception.NotFoundException;
import com.asj.bootcamp.mapper.ItemMapper;
import com.asj.bootcamp.service.CategoryService;
import com.asj.bootcamp.service.ItemService;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;
    private final ItemMapper mapper;
    private final CategoryService categoryService;

    public ItemController(ItemService service, ItemMapper mapper, CategoryService categoryService) {
        this.service = service;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody ItemDTO itemDTO) throws NotFoundException {
        Item item = mapper.itemDTOToItemEntity(itemDTO);
        item.setCategory(categoryService.getCategory(itemDTO.getIdCategory()));

        ItemCompletoDTO tmp = mapper.itemEntityToItemDTO(service.createItem(item));

        return ResponseEntity.status(HttpStatus.CREATED).body(tmp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItem(@PathVariable Integer id){
        try {
            Item item =  service.getItem(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.itemEntityToItemDTO(item));
        }
        catch (NotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Integer id, @RequestBody ItemDTO itemDTO){
        try {
            Item tmp = mapper.itemDTOToItemEntity(itemDTO);

            tmp.setCategory(categoryService.getCategory(itemDTO.getIdCategory()));
            ItemCompletoDTO updated = mapper.itemEntityToItemDTO(service.updateItem(id, tmp));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
        }
        catch (NotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer id){
        try {
            service.deleteItem(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item no encontrado");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllItems(){
        List<Item> items = service.getAll();
        List<ItemCompletoDTO> itemCompletoDTOS = new ArrayList<>();
        for (Item item : items){
            itemCompletoDTOS.add(mapper.itemEntityToItemDTO(item));
        }

        return ResponseEntity.status(HttpStatus.OK).body(itemCompletoDTOS);
    }

}