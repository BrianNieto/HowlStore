package com.asj.bootcamp.service;

import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.exception.NotFoundException;

import java.util.List;

public interface ItemService {

    Item createItem(Item item);

    Item getItem(Integer id) throws NotFoundException;

    Item updateItem(Integer id, Item tmp);

    void deleteItem(Integer id);

    boolean itemExist(String nombreItem, String estadoItem);

    List<Item> getAll();

}