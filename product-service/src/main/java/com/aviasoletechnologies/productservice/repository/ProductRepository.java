package com.aviasoletechnologies.productservice.repository;

import com.aviasoletechnologies.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product getProductByProductName(String productName);
}
