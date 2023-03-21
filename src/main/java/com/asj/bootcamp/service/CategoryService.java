package com.asj.bootcamp.service;

import com.asj.bootcamp.entity.Category;
import com.asj.bootcamp.exception.NotFoundException;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategory(Integer id);

    Category updateCategory(Integer id, Category tmp);

    void deleteCategory(Integer id);

    boolean existCategory(String nombreCategory);

}