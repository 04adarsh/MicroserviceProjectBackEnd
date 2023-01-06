package com.aviasoletechnologies.productservice.dto;

import com.sun.istack.NotNull;

public class ProductDto {

    private @NotNull Long productId;
    private @NotNull String productName;
    private @NotNull String productDescription;

    private @NotNull String productImageUrl;

    private @NotNull String categoryName;

    private @NotNull Long quantity;

    public ProductDto() {
    }

    public ProductDto(Long productId, String productName, String productDescription, String productImageUrl, String categoryName, Long quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
