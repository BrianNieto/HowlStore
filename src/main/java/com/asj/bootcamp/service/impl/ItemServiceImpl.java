package com.asj.bootcamp.service.impl;

import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.repository.ItemRepository;
import com.asj.bootcamp.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    ItemRepository repository;

    @Override
    public Item createItem(Item item) {
        if (itemExist(item.getNombreItem(), item.getEstadoItem())) {
            throw new RuntimeException(String.format("Item con ese nombre y estado ya registrado"));
        }
        return repository.save(item);
    }

    @Override
    public Item getItem(Integer id) {
        Optional<Item> optionalItem = repository.findById(id);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        }
        else {
            throw new RuntimeException("Usuario con id " + id + " no existe");
        }
    }

    @Override
    public Item updateItem(Integer id, Item tmp) {
        Item itempUpdated;
        Optional<Item> optionalItem = repository.findById(id);
        if (optionalItem.isPresent()){
            itempUpdated = optionalItem.get();
        }
        else {
            throw new RuntimeException("Item con id " + id + " no existe");
        }

        itempUpdated.setNombreItem(tmp.getNombreItem());
        itempUpdated.setPrecioItem(tmp.getPrecioItem());
        itempUpdated.setEstadoItem(tmp.getEstadoItem());
        itempUpdated.setStockItem(tmp.getStockItem());
        itempUpdated.setCategoria(tmp.getCategoria());

        return repository.save(itempUpdated);
    }

    @Override
    public void deleteItem(Integer id) {
        Optional<Item> optionalItem = repository.findById(id);
        if (optionalItem.isPresent()) {
            repository.deleteById(id);
        }
        else {
            throw new RuntimeException("Usuario con id " + id + " no existe");
        }
    }

    private boolean itemExist(String nombreItem, String estadoItem) {
        return repository.findByNombreItemAndEstadoItem(nombreItem, estadoItem).isPresent();
    }

}