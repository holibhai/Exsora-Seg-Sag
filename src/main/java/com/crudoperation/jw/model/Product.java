package com.crudoperation.jw.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ProductName;
    private String ProductDescription;
    private float ProductPrice;
    private int ProductQuantity;
    private String productStatus;
    private boolean isAvailable;


    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    private String productType;

    public Product(int id, String productName, String productDescription, float productPrice, int productQuantity, String productStatus, boolean isAvailable, String imaageName, String imageType, byte[] imageData, String productType) {
        this.id = id;
        ProductName = productName;
        ProductDescription = productDescription;
        ProductPrice = productPrice;
        ProductQuantity = productQuantity;
        this.productStatus = productStatus;
        this.isAvailable = isAvailable;
        this.imageName = imaageName;
        this.imageType = imageType;
        this.imageData = imageData;
        this.productType = productType;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public float getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(float productPrice) {
        ProductPrice = productPrice;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        ProductQuantity = productQuantity;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImaageName() {
        return imageName;
    }

    public void setImaageName(String imaageName) {
        this.imageName = imaageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
