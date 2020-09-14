package com.project.c3.demo.dao;

import com.project.c3.demo.entity.Order;
import com.project.c3.demo.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderDAO {
    Map<Integer, Order> maps;
    private static OrderDAO dao;
    int id;

    private OrderDAO() {
        maps = new HashMap<>();
        id = 1;

    }

    public static OrderDAO getDao() {
        if (dao == null) {
            dao = new OrderDAO();
        }
        return dao;
    }

    public Order save(Order order) {
        if (order.getId() == 0) {
            order.setId(id);
            id++;
        }
        maps.put(order.getId(), order);
        return order;
    }

    public List<Order> find() {
        return new ArrayList<>(maps.values());

    }

    public Order findById(int id) {
        if (maps.containsKey(id)) {
            return maps.get(id);
        }
        return null;

    }


}
