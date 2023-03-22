package com.asj.bootcamp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idItem;
    @Column(nullable = false)
    String nombreItem;
    @Column(nullable = false)
    Integer precioItem;
    @Column(nullable = false)
    Integer stockItem;
    @Column(nullable = false)
    String estadoItem;

    @Column(nullable = false)
    String srcItem;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_categoria")
    Category category;

}