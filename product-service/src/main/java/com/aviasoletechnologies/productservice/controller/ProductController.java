package com.aviasoletechnologies.productservice.controller;

import com.aviasoletechnologies.productservice.dto.DeleteResponse;
import com.aviasoletechnologies.productservice.dto.ProductDto;
import com.aviasoletechnologies.productservice.model.Product;
import com.aviasoletechnologies.productservice.repository.ProductRepository;
import com.aviasoletechnologies.productservice.service.serviceimpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200","*"},allowedHeaders = {"Origin", "Access-Control-Allow-Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"})
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductRepository productRepository;


//    @PostMapping(value = "/create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> createProduct(@RequestPart("product") ProductDto product,
//                                           @RequestPart("imageFile")MultipartFile[] multipartFiles) {
//        try{
//            Set<ProductImage> images=uploadImages(multipartFiles);
//            product.setProductImage(images);
//            Product productResp=this.productService.createProduct(product);
//            return ResponseEntity.ok(productResp);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }

//        public Set<ProductImage> uploadImages(MultipartFile[] multipartFiles) throws Exception{
//            Set<ProductImage> images=new HashSet<>();
//            for(MultipartFile file:multipartFiles){
//                ProductImage productImage=new ProductImage(
//                        file.getOriginalFilename(),
//                        file.getContentType(),
//                        file.getBytes()
//                );
//                images.add(productImage);
//            }
//            return images;
//    }
//

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        Product product=this.productService.createProduct(productDto);
        return ResponseEntity.ok(product);
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

    @GetMapping("/get/{getId}")
    public ResponseEntity<Product> getProductById(@PathVariable("getId") Long getId){
        Product product=this.productService.getProductById(getId);
        return ResponseEntity.ok(product);
    }

}

