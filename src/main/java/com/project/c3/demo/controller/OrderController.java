package com.project.c3.demo.controller;

import com.project.c3.demo.entity.Cart;
import com.project.c3.demo.entity.Order;
import com.project.c3.demo.service.CartService;
import com.project.c3.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @GetMapping("{cartId}")
    public Order placeOrder(@PathVariable("cartId") int cartId )throws Exception{
        return orderService.addOrder(cartId);
    }

    @GetMapping("")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }




}
