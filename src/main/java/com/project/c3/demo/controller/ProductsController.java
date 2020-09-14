package com.project.c3.demo.controller;


import com.project.c3.demo.entity.Product;
import com.project.c3.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController()
@RequestMapping("products")
public class ProductsController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

    @PostMapping("")
    public Product addProduct(@RequestBody  Product product) throws Exception {
        return productService.addProduct(product);
    }





}
