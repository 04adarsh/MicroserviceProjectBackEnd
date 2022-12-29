package com.aviasoletechnologies.productservice.service;

import com.aviasoletechnologies.productservice.model.Product;

import java.util.List;
public interface ProductService {

    Product createProduct(Product product);
    Product updateProduct(Long productId,Product product);

    List<Product> getALlProducts();
    void deleteProduct(Long productId);

}

