package com.aviasoletechnologies.productservice.model;



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

    private String productImageUrl;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    private Long quantity;

    public Product() {
    }

    public Product(Long productId, String productName, String productDescription, String productImageUrl, Category category, Long quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
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

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
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
                ", productImageUrl='" + productImageUrl + '\'' +
                ", category=" + category +
                ", quantity=" + quantity +
                '}';
    }
}