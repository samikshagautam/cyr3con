package com.project.c3.demo.service;

import com.project.c3.demo.dao.CartDAO;
import com.project.c3.demo.dao.ProductDAO;
import com.project.c3.demo.entity.Cart;
import com.project.c3.demo.entity.CartItem;
import com.project.c3.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private ProductDAO productDAO;

    private void validateInventory(CartItem cartItem) throws Exception {
        Product product = productDAO.findById(cartItem.getProductId());
        if (product.getUnits() < cartItem.getQuantity()) {
            throw new Exception("Product is out of Stock");
        }
    }

    public Cart addToCart(CartItem cartItem) throws Exception {
        if (cartItem == null) {
            throw new Exception("Data is Empty!");
        }
        validateInventory(cartItem);
        Cart cart = new Cart();
        cart.getCartItems().add(cartItem);
        return cartDAO.save(cart);
    }

    public Cart addCartItem(int id, CartItem cartItem) throws Exception {
        if (cartItem == null) {
            throw new Exception("Data is Empty");
        }
        validateInventory(cartItem);
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
