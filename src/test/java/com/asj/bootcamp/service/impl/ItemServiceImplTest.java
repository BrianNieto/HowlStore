package com.asj.bootcamp.service.impl;

import com.asj.bootcamp.datos.DatosDummy;
import com.asj.bootcamp.entity.Category;
import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.entity.Persona;
import com.asj.bootcamp.entity.User;
import com.asj.bootcamp.repository.CategoryRepository;
import com.asj.bootcamp.repository.ItemRepository;
import com.asj.bootcamp.service.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@SpringBootTest
class ItemServiceImplTest {

    @MockBean
    private ItemRepository itemRepository;
    @MockBean
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemService service;

    @Test
    @DisplayName("Item created")
    void createItem() {
        Item item = DatosDummy.getItem();

        given(categoryRepository.findById(item.getCategory().getIdCategoria())).willReturn(Optional.of(item.getCategory()));
        service.createItem(item);

        ArgumentCaptor<Item> itemArgumentCaptor = ArgumentCaptor.forClass(Item.class);
        verify(itemRepository).save(itemArgumentCaptor.capture());

        Item itemCaptor = itemArgumentCaptor.getValue();

        assertThat(itemCaptor).isEqualTo(item);

        verify(itemRepository).save(any());
    }

    @Test
    @DisplayName("Item with nombre and estado already exist")
    void createItemAlreadyExist(){
        Item item = DatosDummy.getItem();

        given(categoryRepository.findById(item.getCategory().getIdCategoria())).willReturn(Optional.of(item.getCategory()));
        given(itemRepository.findByNombreItemAndEstadoItem(item.getNombreItem(),item.getEstadoItem())).willReturn(Optional.of(item));
        assertThatThrownBy(() -> service.createItem(item)).isInstanceOf(RuntimeException.class);

    }

    @Test
    @DisplayName("Item with given category not exist")
    void createItemWithoutCategory(){
        Item item = DatosDummy.getItem();

        given(categoryRepository.findById(item.getCategory().getIdCategoria())).willReturn(Optional.empty());

        assertThatThrownBy(() -> service.createItem(item)).isInstanceOf(RuntimeException.class);

    }

    @Test
    @DisplayName("Item found")
    void getItem() {
        Integer idItem = 1;

        when(itemRepository.findById(idItem)).thenReturn(Optional.of(DatosDummy.getItem()));
        Item item = service.getItem(idItem);

        assertThat(item.getIdItem()).isEqualTo(idItem);

    }

    @Test
    @DisplayName("Item not found")
    void getItemWithException() {
        Integer idItem = 1;

        when(itemRepository.findById(idItem)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.getItem(idItem)).isInstanceOf(RuntimeException.class);

    }

    @Test
    @DisplayName("Item updated")
    void updateItem() {
        Integer idItem = 1;
        Integer idCategory = 1;
        Item itemToUpdate = new Item(1,"M9 Bayonet | Tiger Tooth", 45000, 3, "Factory New", "img/img1.jpg", "img/img2.jpg", "img/img3.jpg", DatosDummy.getItem().getCategory());

        given(itemRepository.findById(idItem)).willReturn(Optional.of(DatosDummy.getItem()));
        given(categoryRepository.findById(idCategory)).willReturn(Optional.of(DatosDummy.getItem().getCategory()));
        given(service.updateItem(idItem,itemToUpdate)).willReturn(itemToUpdate);
        Item itemUpdated = service.updateItem(idItem, itemToUpdate);

        ArgumentCaptor<Item> categoryArgumentCaptor = ArgumentCaptor.forClass(Item.class);
        verify(itemRepository).save(categoryArgumentCaptor.capture());

        assertThat(itemUpdated.getPrecioItem()).isEqualTo(itemToUpdate.getPrecioItem());
        assertThat(itemUpdated.getStockItem()).isEqualTo(itemToUpdate.getStockItem());
    }

    @Test
    @DisplayName("Item with category not existing")
    void updateItemWithoutExistingCategory() {
        Integer idItem = 1;
        Integer idCategory = 1;
        Category tmp = new Category(2,"Cuchillo");
        Item itemToUpdate = new Item(1,"M9 Bayonet | Tiger Tooth", 45000, 3, "Factory New", "img/img1.jpg", "img/img2.jpg", "img/img3.jpg", tmp);

        given(categoryRepository.findById(idCategory)).willReturn(Optional.empty());

        assertThatThrownBy(() -> service.updateItem(idItem,itemToUpdate)).isInstanceOf(RuntimeException.class);

    }

    @Test
    @DisplayName("Item without exist")
    void updateItemWithoutExisting() {
        Integer idItem = 1;
        Integer idCategory = 1;
        Category tmp = new Category(2,"Cuchillo");
        Item itemToUpdate = new Item(1,"M9 Bayonet | Tiger Tooth", 45000, 3, "Factory New", "img/img1.jpg", "img/img2.jpg", "img/img3.jpg", tmp);

        given(categoryRepository.findById(idCategory)).willReturn(Optional.of(DatosDummy.getItem().getCategory()));
        given(itemRepository.findById(idItem)).willReturn(Optional.empty());

        assertThatThrownBy(() -> service.updateItem(idItem,itemToUpdate)).isInstanceOf(RuntimeException.class);

    }

    @Test
    @DisplayName("Item deleted")
    void deleteItem() {
        Integer idItem = 1;

        given(itemRepository.findById(idItem)).willReturn(Optional.of(DatosDummy.getItem()));
        willDoNothing().given(itemRepository).deleteById(idItem);
        service.deleteItem(idItem);

        verify(itemRepository,times(1)).deleteById(any());

    }

    @Test
    @DisplayName("Item with exception")
    void deleteItemWithException() {
        Integer idItem = 1;

        given(itemRepository.findById(idItem)).willReturn(Optional.empty());

        assertThatThrownBy(() -> service.deleteItem(idItem)).isInstanceOf(RuntimeException.class);

    }

    @Test
    void itemExist() {
        String nombreItem = "M9 Bayonet | Tiger Tooth";
        String estadoItem = "Factory New";

        given(itemRepository.findByNombreItemAndEstadoItem(nombreItem,estadoItem)).willReturn(Optional.of(DatosDummy.getItem()));
        Boolean itemExist = service.itemExist(nombreItem,estadoItem);

        assertThat(itemExist).isTrue();

    }

    @Test
    void getAllItems() {
        List<Item> items = new ArrayList<>();
        items.add(DatosDummy.getItem());
        items.add(DatosDummy.getItem2());

        given(itemRepository.findAll()).willReturn(items);
        List<Item> itemList = service.getAllItems();

        verify(itemRepository,times(1)).findAll();
        assertThat(itemList.size()).isEqualTo(2);

    }

}