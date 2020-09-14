package com.project.c3.demo.dao;


import com.project.c3.demo.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDAO {

    Map<Integer, Product> maps;
    private static ProductDAO dao;
    int id;

    private ProductDAO() {
        maps = new HashMap<>();
        id = 1;

    }

    public static ProductDAO getDao() {
        if (dao == null) {
            dao = new ProductDAO();
        }
        return dao;
    }

    public Product save(Product product) {
        if (product.getId() == 0) {
            product.setId(id);
            id++;
        }
        maps.put(product.getId(), product);
        return product;
    }

    public List<Product> find() {
        return new ArrayList<>(maps.values());

    }

    public Product findById(int id) {
        if (maps.containsKey(id)) {
            return maps.get(id);
        }
        return null;

    }


}
