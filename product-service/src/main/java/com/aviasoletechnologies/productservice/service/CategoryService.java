package com.aviasoletechnologies.productservice.service;

import com.aviasoletechnologies.productservice.model.Category;

import java.util.Set;

public interface CategoryService {

    Category createCategory(Category category);
    Category upadteCategory(Long id, Category category);

    void deleteCategory(Long id);

    Category getCategoryById(Long id);

    Set<Category> getAllCategory();
}
