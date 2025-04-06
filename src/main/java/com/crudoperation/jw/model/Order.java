package com.crudoperation.jw.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float netTotal;
    private float offer;
    private String location;
    private String deliveryType;
    private String pickupDate;
    private String city;
    private float deliveryCharge;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "billing_id",nullable = false)
    private Billing billing;

    public Order(int id, float netTotal, float offer, String location, String deliveryType, String pickupDate, String city, float deliveryCharge, List<OrderItem> orderItems, User user, Billing billing) {
        this.id = id;
        this.netTotal = netTotal;
        this.offer = offer;
        this.location = location;
        this.deliveryType = deliveryType;
        this.pickupDate = pickupDate;
        this.city = city;
        this.deliveryCharge = deliveryCharge;
        this.orderItems = orderItems;
        this.user = user;
        this.billing = billing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(float deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
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
