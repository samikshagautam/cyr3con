package com.project.c3.demo.dao;

import com.project.c3.demo.entity.Cart;
import com.project.c3.demo.entity.Cart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CartDAO {
    Map<Integer, Cart> maps;
    private static CartDAO dao;
    int id;

    private CartDAO() {
        maps = new HashMap<>();
        id = 1;

    }

    public static CartDAO getDao() {
        if (dao == null) {
            dao = new CartDAO();
        }
        return dao;
    }

    public Cart save(Cart cart) {
        if (cart.getId() == 0) {
            cart.setId(id);
            id++;
        }
        maps.put(cart.getId(), cart);
        return cart;
    }

    public List<Cart> find() {
        return new ArrayList<>(maps.values());

    }

    public Cart findById(int id) {
        if (maps.containsKey(id)) {
            return maps.get(id);
        }
        return null;

    }

}
