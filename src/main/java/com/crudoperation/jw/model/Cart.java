package com.crudoperation.jw.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    private float totalPrice;


}
