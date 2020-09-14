package com.project.c3.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private List<OrderItem> orderItems;

    public Order() {
      orderItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
