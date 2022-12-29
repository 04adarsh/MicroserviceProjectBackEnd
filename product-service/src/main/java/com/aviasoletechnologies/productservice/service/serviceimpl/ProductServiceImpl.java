package com.aviasoletechnologies.productservice.service.serviceimpl;

import com.aviasoletechnologies.productservice.exception.CustomException;
import com.aviasoletechnologies.productservice.model.Product;
import com.aviasoletechnologies.productservice.repository.ProductRepository;
import com.aviasoletechnologies.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        Product productResp = this.productRepository.getProductByProductName(product.getProductName());
        if (productResp != null) {
            throw new CustomException("product id already exists..");
        }

        return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Product productResp=this.productRepository.findById(productId)
                .orElseThrow(()-> new  CustomException("product does not exist with id"+productId));
        productResp.setProductName(product.getProductName());
        productResp.setProductDescription(product.getProductDescription());
        return this.productRepository.save(productResp);
    }

    @Override
    public List<Product> getALlProducts() {
        List<Product> productList=this.productRepository.findAll();
        return productList;
    }

    @Override
    public void deleteProduct(Long productId) {
    Product productResp=this.productRepository.findById(productId).orElseThrow(()-> new CustomException("product does not exist with id"+productId));
    this.productRepository.delete(productResp);
    }
}

