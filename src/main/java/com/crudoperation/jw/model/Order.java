package com.crudoperation.jw.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float netTotal;
    private float offer;
    private String deliveryType;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "billing_id",nullable = false)
    private Billing billing;

    public Order(int id, float netTotal, float offer, String deliveryType, List<OrderItem> orderItems, User user, Billing billing) {
        this.id = id;
        this.netTotal = netTotal;
        this.offer = offer;
        this.deliveryType = deliveryType;
        this.orderItems = orderItems;
        this.user = user;
        this.billing = billing;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public float getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(float netTotal) {
        this.netTotal = netTotal;
    }

    public float getOffer() {
        return offer;
    }

    public void setOffer(float offer) {
        this.offer = offer;
    }



    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }



    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }
}
