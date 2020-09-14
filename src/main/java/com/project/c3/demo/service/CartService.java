package com.project.c3.demo.service;

import com.project.c3.demo.dao.CartDAO;
import com.project.c3.demo.entity.Cart;
import com.project.c3.demo.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartDAO cartDAO;

    public Cart addToCart(CartItem cartItem) throws Exception {
        if (cartItem == null) {
            throw new Exception("Data is Empty!");
        }
        Cart cart = new Cart();
        cart.getCartItems().add(cartItem);
        return cartDAO.save(cart);
    }

    public Cart addCartItem(int id, CartItem cartItem) throws Exception {
        if (cartItem == null) {
            throw new Exception("Data is Empty");
        }
        Cart cart = cartDAO.findById(id);
        if (cart == null) {
            throw new Exception("Field is empty");
        }
        cart.getCartItems().add(cartItem);
        return cartDAO.save(cart);
    }


    public List<Cart> getAllCarts() {
        return cartDAO.find();
    }


}
