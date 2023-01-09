//package com.aviasoletechnologies.productservice.model;
//
//import javax.persistence.*;
//import java.util.Arrays;
//
//@Entity
//public class ProductImage {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long imageId;
//
//
//    private String name;
//
//
//    private String type;
//
//    @Column(length = 5000000)
//    private byte[] imageByte;
//
//    public ProductImage() {
//    }
//
//    public ProductImage(String name, String type, byte[] imageByte) {
//        this.name = name;
//        this.type = type;
//        this.imageByte = imageByte;
//    }
//
//    public Long getImageId() {
//        return imageId;
//    }
//
//    public void setImageId(Long imageId) {
//        this.imageId = imageId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public byte[] getImageByte() {
//        return imageByte;
//    }
//
//    public void setImageByte(byte[] imageByte) {
//        this.imageByte = imageByte;
//    }
//
//    @Override
//    public String toString() {
//        return "ProductImage{" +
//                "imageId=" + imageId +
//                ", name='" + name + '\'' +
//                ", type='" + type + '\'' +
//                ", imageByte=" + Arrays.toString(imageByte) +
//                '}';
//    }
//}
