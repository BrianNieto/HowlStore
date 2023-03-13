package com.asj.bootcamp.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCompra;
    @Column(nullable = false)
    String comentario;
    @Column(nullable = false)
    LocalDate fecha;
    @Column(nullable = false)
    String estadoPedido;

    /*@OneToMany
    @JoinColumn(name = "idItem")
    Item item;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    User user;
*/
}