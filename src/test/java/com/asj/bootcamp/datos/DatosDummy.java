package com.asj.bootcamp.datos;

import com.asj.bootcamp.entity.Category;

public class DatosDummy {

    //CATEGORIAS
    public static Category getCategorySMG(){
        return new Category(1,"SMG");
    }
    public static Category getCategoryRifles(){
        return new Category(2,"Rifles");
    }

}