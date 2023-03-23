package com.asj.bootcamp.controller;

import com.asj.bootcamp.dto.CompraCompletaDTO;
import com.asj.bootcamp.dto.CompraDTO;
import com.asj.bootcamp.entity.Compra;
import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.entity.User;
import com.asj.bootcamp.exception.NotFoundException;
import com.asj.bootcamp.mapper.CompraMapper;
import com.asj.bootcamp.service.CompraService;
import com.asj.bootcamp.service.ItemService;
import com.asj.bootcamp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraService service;
    private final UserService userService;
    private final ItemService itemService;
    private final CompraMapper mapper;

    public CompraController(CompraService service, UserService userService, ItemService itemService, CompraMapper mapper) {
        this.service = service;
        this.userService = userService;
        this.itemService = itemService;
        this.mapper = mapper;
    }


    @PostMapping
    public ResponseEntity<?> createCompra(@RequestBody CompraDTO compraDTO) throws NotFoundException {
        User user = userService.getUser(compraDTO.getIdUser());
        Item item = itemService.getItem(compraDTO.getIdItem());

        Compra compra = mapper.compraDTOToEntity(compraDTO);
        compra.setUser(user);
        compra.setItem(item);

        CompraCompletaDTO compraCompletaDTO = mapper.compraEntityToCompraCompletaDTO(service.createCompra(compra));
        return ResponseEntity.status(HttpStatus.CREATED).body(compraCompletaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCompra(@PathVariable Integer id){
        try {
            Compra compra =  service.getCompra(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.compraEntityToCompraCompletaDTO(compra));
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompra(@PathVariable Integer id, @RequestBody CompraDTO compraDTO){
        try {
            Compra tmp = mapper.compraDTOToEntity(compraDTO);
            CompraCompletaDTO updated = mapper.compraEntityToCompraCompletaDTO(service.updateCompra(id, tmp));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
        }
        catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompra(@PathVariable Integer id){
        try {
            service.deleteCompra(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada");
        }
    }
}