package com.project.c3.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int id;
    private List<CartItem> cartItems;

    public  Cart(){
        cartItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
