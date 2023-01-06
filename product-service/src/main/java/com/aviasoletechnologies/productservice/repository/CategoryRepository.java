package com.aviasoletechnologies.productservice.repository;

import com.aviasoletechnologies.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;


public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByCategoryName(String categoryName);
}
