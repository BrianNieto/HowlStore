package com.asj.bootcamp.controller;

import com.asj.bootcamp.dto.UserDTO;
import com.asj.bootcamp.entity.User;
import com.asj.bootcamp.exception.NotFoundException;
import com.asj.bootcamp.mapper.UserMapper;
import com.asj.bootcamp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

        private final UserService service;
        private final UserMapper userMapper;

        public UserController(UserService service, UserMapper userMapper) {
                this.service = service;
                this.userMapper = userMapper;
        }

        @PostMapping
        public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
                User user = userMapper.userDTOToUserEntity(userDTO);
                UserDTO tmp = userMapper.userEntityToUserDTO(service.createUser(user));
                return ResponseEntity.status(HttpStatus.CREATED).body(tmp);
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getUser(@PathVariable Integer id){
                try {
                        User user =  service.getUser(id);
                        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userMapper.userEntityToUserDTO(user));
                }
                catch (NotFoundException ex){
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
                }
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO){
                try {
                        User userTmp = userMapper.userDTOToUserEntity(userDTO);
                        User updated = service.updateUser(id, userTmp);
                        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
                }
                catch (RuntimeException ex){
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
                }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteUser(@PathVariable Integer id){
                try {
                        service.deleteUser(id);
                        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
                }
                catch (RuntimeException ex){
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
                }
        }

}