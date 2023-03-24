package com.asj.bootcamp.datos;

import com.asj.bootcamp.entity.Category;
import com.asj.bootcamp.entity.Item;
import com.asj.bootcamp.entity.Persona;
import com.asj.bootcamp.entity.User;

public class DatosDummy {

    //CATEGORIAS
    public static Category getCategorySMG(){
        return new Category(1,"SMG");
    }
    public static Category getCategoryRifles(){
        return new Category(2,"Rifles");
    }

    public static User getUser(){
        Persona tmp = new Persona(1,"Pipo", "Pom");
        return new User(1,"test@test.com", "1234", tmp);
    }

    public static Item getItem(){
        Category tmp = new Category(1,"Cuchillo");
        return new Item(1,"M9 Bayonet | Tiger Tooth", 30000, 5, "Factory New", "img/img1.jpg", "img/img2.jpg", "img/img3.jpg", tmp);
    }

}