package com.crudoperation.jw.model;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Favaurite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private int productId;

    public Favaurite(int id, User user, int productId) {
        this.id = id;
        this.user = user;
        this.productId = productId;
    }
    public Favaurite() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
