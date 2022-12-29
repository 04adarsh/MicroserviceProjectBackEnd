package com.aviasoletechnologies.productservice.controller;

import com.aviasoletechnologies.productservice.model.Product;
import com.aviasoletechnologies.productservice.repository.ProductRepository;
import com.aviasoletechnologies.productservice.service.serviceimpl.ProductServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product productResp=this.productService.createProduct(product);
        return ResponseEntity.ok(productResp);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getALlProducts(){
        List<Product> productList=this.productService.getALlProducts();
        return ResponseEntity.ok(productList);
    }
    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product){
        Product productResp=this.productService.updateProduct(productId,product);
        return ResponseEntity.ok(productResp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok("product deleted successfully");
    }

}
