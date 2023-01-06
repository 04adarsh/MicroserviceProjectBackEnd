package com.aviasoletechnologies.productservice.controller;

import com.aviasoletechnologies.productservice.dto.DeleteResponse;
import com.aviasoletechnologies.productservice.dto.ProductDto;
import com.aviasoletechnologies.productservice.model.Product;
import com.aviasoletechnologies.productservice.repository.ProductRepository;
import com.aviasoletechnologies.productservice.service.serviceimpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200","*"},allowedHeaders = {"Origin", "Access-Control-Allow-Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"})
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto product) {
        Product productResp=this.productService.createProduct(product);
        if(productResp==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(productResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getALlProducts(){
        List<Product> productList=this.productService.getALlProducts();
        return ResponseEntity.ok(productList);
    }


    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto){
        Product productResp=this.productService.updateProduct(productId,productDto);
        return ResponseEntity.ok(productResp);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteResponse> deleteProduct(@PathVariable("id") Long id){
        this.productService.deleteProduct(id);
        DeleteResponse deleteResponse=new DeleteResponse("Product Deleted Successfully");
        return ResponseEntity.ok(deleteResponse);
    }

}

