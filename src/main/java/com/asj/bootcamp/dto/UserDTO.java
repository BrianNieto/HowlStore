package com.asj.bootcamp.dto;

import com.asj.bootcamp.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private Integer idUser;
    private String mail;
    private String password;
    private Persona persona;
}