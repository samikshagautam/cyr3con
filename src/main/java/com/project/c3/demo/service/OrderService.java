package com.project.c3.demo.service;

import com.project.c3.demo.dao.CartDAO;
import com.project.c3.demo.dao.OrderDAO;
import com.project.c3.demo.entity.Cart;
import com.project.c3.demo.entity.CartItem;
import com.project.c3.demo.entity.Order;
import com.project.c3.demo.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CartDAO cartDAO;

    public Order addOrder(int cartId) throws Exception {
        if (cartId == 0) {
            throw new Exception("cart is Empty!");
        }
        Cart cart = cartDAO.findById(cartId);
        if(cart == null){
            throw  new Exception("Invalid cart id");
        }
        Order order = new Order();
        for (CartItem item : cart.getCartItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(item.getQuantity());
            orderItem.setUnitPrice(item.getUnitPrice());
            orderItem.setProductId(item.getProductId());
            order.getOrderItems().add(orderItem);
        }
        return orderDAO.save(order);
    }


    public List<Order> getAllOrders() {
        return orderDAO.find();
    }


}
