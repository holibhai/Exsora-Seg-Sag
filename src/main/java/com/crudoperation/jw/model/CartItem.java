package com.crudoperation.jw.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private float price;
    private int productId;
    private float subtotal;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;

    public CartItem(int id, int quantity, float price, int productId, float subtotal, Cart cart) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
        this.subtotal = subtotal;
        this.cart = cart;
    }

    public CartItem() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
