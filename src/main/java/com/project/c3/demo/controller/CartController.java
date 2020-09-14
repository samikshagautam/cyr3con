package com.project.c3.demo.controller;

import com.project.c3.demo.entity.Cart;
import com.project.c3.demo.entity.CartItem;
import com.project.c3.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("{id}")
    public Cart addToCart(@RequestBody CartItem cartItem,@PathVariable("id") int id) throws  Exception{

        return cartService.addCartItem(id,cartItem);
    }

    @PostMapping("")
    public Cart addCartItem(@RequestBody CartItem cartItem) throws  Exception{
        return cartService.addToCart(cartItem);
    }

    @GetMapping("")
    public List<Cart> getCart(){
        return cartService.getAllCarts();
    }

}
