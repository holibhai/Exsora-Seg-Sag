package com.crudoperation.jw.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ProductName;
    private String ProductDescription;
    private float ProductPrice;
    private float discount;
    private int ProductQuantity;
    private float width;
    private float height;
    private float depth;
    private String warrantyInf;
    private String Description;
    private Date date;
    private String productType;
    private String category;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;


    public Product(int id, String productName, String productDescription, float productPrice, float discount, int productQuantity, float width, float height, float depth, String warrantyInf, String description, Date date, String productType, String category, String imageName, String imageType, byte[] imageData) {
        this.id = id;
        ProductName = productName;
        ProductDescription = productDescription;
        ProductPrice = productPrice;
        this.discount = discount;
        ProductQuantity = productQuantity;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.warrantyInf = warrantyInf;
        Description = description;
        this.date = date;
        this.productType = productType;
        this.category = category;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageData = imageData;
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        ProductQuantity = productQuantity;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public String getWarrantyInf() {
        return warrantyInf;
    }

    public void setWarrantyInf(String warrantyInf) {
        this.warrantyInf = warrantyInf;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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

}
