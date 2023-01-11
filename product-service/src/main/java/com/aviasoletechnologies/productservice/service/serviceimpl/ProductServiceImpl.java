package com.aviasoletechnologies.productservice.service.serviceimpl;

import com.aviasoletechnologies.productservice.dto.ProductDto;
import com.aviasoletechnologies.productservice.exception.CustomException;
import com.aviasoletechnologies.productservice.model.Product;
import com.aviasoletechnologies.productservice.repository.CategoryRepository;
import com.aviasoletechnologies.productservice.repository.ProductRepository;
import com.aviasoletechnologies.productservice.service.ProductService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private CategoryRepository categoryRepository;

    public Product getProduct(ProductDto productDto) throws JsonProcessingException {
        Product product=new Product();
        product.setProductName(productDto.getProductName());
        product.setProductDescription(productDto.getProductDescription());
        product.setQuantity(productDto.getQuantity());
        String imageNames=productDto.getProductName();
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode=objectMapper.readTree(imageNames);
        product.setImageName(jsonNode);
        product.setCategory(this.categoryRepository.findByCategoryName(productDto.getCategoryName()));
        return product;
    }

    public Product createProduct(ProductDto productDto) {
       Product product=new Product();

        try {
            product=this.getProduct(productDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDto) {
       Product  productResp=this.productRepository.findById(productId).orElseThrow(()->new CustomException("product not found with id: "+productId));
        productResp.setProductName(productDto.getProductName());
        productResp.setProductDescription(productDto.getProductDescription());
        productResp.setCategory(this.categoryRepository.findByCategoryName(productDto.getCategoryName()));
        productResp.setQuantity(productDto.getQuantity());
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

