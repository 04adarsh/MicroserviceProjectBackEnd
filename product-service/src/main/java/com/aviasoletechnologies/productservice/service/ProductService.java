package com.aviasoletechnologies.productservice.service;

import com.aviasoletechnologies.productservice.dto.ProductDto;
import com.aviasoletechnologies.productservice.model.Product;

import java.util.List;
public interface ProductService {

    Product createProduct(ProductDto productDto);
    Product updateProduct(Long productId,ProductDto productDto);
    List<Product> getALlProducts();
    void deleteProduct(Long productId);

}

