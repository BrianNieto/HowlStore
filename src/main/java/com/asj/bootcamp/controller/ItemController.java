package com.asj.bootcamp.controller;

import com.asj.bootcamp.dto.ItemDTO;
import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.exception.NotFoundException;
import com.asj.bootcamp.mapper.ItemMapper;
import com.asj.bootcamp.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;
    private final ItemMapper mapper;

    public ItemController(ItemService service, ItemMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody ItemDTO itemDTO){
        Item item = mapper.itemDTOToItemEntity(itemDTO);
        ItemDTO tmp = mapper.itemEntityToItemDTO(service.createItem(item));
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
            ItemDTO updated = mapper.itemEntityToItemDTO(service.updateItem(id, tmp));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
        }
        catch (RuntimeException ex){
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

}