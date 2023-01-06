package com.aviasoletechnologies.productservice.controller;

import com.aviasoletechnologies.productservice.dto.DeleteResponse;
import com.aviasoletechnologies.productservice.model.Category;
import com.aviasoletechnologies.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = {"http://localhost:4200","*"},
        allowedHeaders = {"Origin", "Access-Control-Allow-Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"})
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category categoryResp= this.categoryService.createCategory(category);
      return ResponseEntity.ok(categoryResp);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id,@RequestBody Category category){
        Category categoryResp=this.categoryService.upadteCategory(id,category);
        return ResponseEntity.ok(categoryResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Set<Category>> getAllCategory(){
        Set<Category> categories=this.categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<DeleteResponse> deleteCategory(@PathVariable("categoryId") Long id){
        this.categoryService.deleteCategory(id);
        DeleteResponse deleteResponse=new DeleteResponse("Category deleted successfully...");
        return ResponseEntity.ok(deleteResponse);
    }
}
