package com.aviasoletechnologies.productservice.model;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long productId;
    private String productName;
    private String productDescription;

//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(name="product_images",
//        joinColumns = {@JoinColumn(name="product_id")},
//        inverseJoinColumns = {@JoinColumn(name = "image_id")}
//    )
//    private Set<ProductImage> productImage;
    @Column(columnDefinition = "text")
    private String imageName;



    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    private Long quantity;




    public Product() {
    }

    public Product(String productName, String productDescription, String imageName, Category category, Long quantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.imageName = imageName;
        this.category = category;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public JSONObject getImageName() {
        JSONObject jsonObject =(JSONObject) JSONValue.parse(this.imageName);
      return jsonObject;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", imageName=" + imageName +
                ", category=" + category +
                ", quantity=" + quantity +
                '}';
    }


}