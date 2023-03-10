package com.asj.bootcamp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    Integer idUser;
    String mail;
    String password;
    Integer idPersona;

}