package com.project.c3.demo.entity;

public class OrderItem {

    private int id;
    private int quantity;
    private double unitPrice;
    private int productId;

    public OrderItem(){

    }

    public OrderItem(int id, int quantity, double unitPrice, int productId) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productId = productId;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
