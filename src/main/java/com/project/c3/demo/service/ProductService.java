package com.project.c3.demo.service;


import com.project.c3.demo.dao.ProductDAO;
import com.project.c3.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductDAO productDAO;

    public Product addProduct(Product product) throws Exception {
        if (product == null) {
            throw new Exception("Data is Empty!");
        }
        if (product.getName() == null) {
            throw new Exception("Please add name");
        }

        if (product.getPrice() == 0) {
            throw new Exception("Product price should't be zero");
        }

        if (product.getUnits() == 0) {
            throw new Exception("Please enter product inventory");
        }
        return productDAO.save(product);
    }

    public Product updateProduct(Product product) throws Exception {
        if (product == null) {
            throw new Exception("Data is Empty!");
        }
        if (product.getName() == null) {
            throw new Exception("Please add name");
        }

        if (product.getPrice() == 0) {
            throw new Exception("Product price should't be zero");
        }
        Product product1 = productDAO.findById(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setUnits(product.getUnits());
        return productDAO.save(product1);

    }

    public List<Product> getAllProducts() {
        return productDAO.find();
    }


}

