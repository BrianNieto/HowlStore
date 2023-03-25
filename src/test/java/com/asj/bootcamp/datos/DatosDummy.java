package com.asj.bootcamp.datos;

import com.asj.bootcamp.entity.*;

import java.time.LocalDate;

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

    public static Item getItem2(){
        Category tmp = new Category(2,"Pistolas");
        return new Item(2,"Glock-18 | Gamma Doppler", 15000, 3, "Factory New", "img/img4.jpg", "img/img5.jpg", "img/img6.jpg", tmp);
    }

    public static Contact getContact(){
        return new Contact(1, "Naim", "Cambe", "naim@gmail.com","Dudas", "zz z z a dawd ad a");
    }

    public static Recomendacion getRecomendacion(){
        return new Recomendacion(1,"Naim Cambe", "zz z z a dawd ad a",  LocalDate.of(2021,04,23), "img/imgRecomendado.jpg");
    }

    public static Recomendacion getRecomendacion2(){
        return new Recomendacion(2,"Roberto Miwaq", "otro más?",  LocalDate.of(2023,02,14), "img/imgRecomendado2.jpg");
    }

    public static Compra getCompra(){
        return new Compra(1,"Realizado", LocalDate.of(2022,03,12), "REALIZADO", getItem(),getUser());
    }

}