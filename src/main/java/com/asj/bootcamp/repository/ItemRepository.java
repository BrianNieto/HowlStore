package com.asj.bootcamp.repository;

import com.asj.bootcamp.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Optional<Item> findByNombreItemAndEstadoItem(String nombreItem, String estadoItem);

}