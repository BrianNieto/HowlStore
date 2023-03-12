package com.asj.bootcamp.controller;

import com.asj.bootcamp.dto.CategoryDTO;
import com.asj.bootcamp.dto.CompraDTO;
import com.asj.bootcamp.entity.Category;
import com.asj.bootcamp.entity.Compra;
import com.asj.bootcamp.exception.NotFoundException;
import com.asj.bootcamp.mapper.CompraMapper;
import com.asj.bootcamp.service.CompraService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
@AllArgsConstructor
@NoArgsConstructor
public class CompraController {

    private CompraService service;
    private CompraMapper mapper;


    public ResponseEntity<?> createCompra(@RequestBody CompraDTO compraDTO){
        Compra compra = mapper.compraDTOToEntity(compraDTO);
        CompraDTO tmp = mapper.compraEntityToCompraDTO(service.createCompra(compra));
        return ResponseEntity.status(HttpStatus.CREATED).body(tmp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Integer id){
        try {
            Compra compra =  service.getCompra(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.compraEntityToCompraDTO(compra));
        }
        catch (NotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CompraDTO compraDTO){
        try {
            Compra tmp = mapper.compraDTOToEntity(compraDTO);
            CompraDTO updated = mapper.compraEntityToCompraDTO(service.updateCompra(id, tmp));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
        }
        catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        try {
            service.deleteCompra(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada");
        }
    }
}