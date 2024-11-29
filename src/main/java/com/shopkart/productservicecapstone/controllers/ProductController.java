package com.shopkart.productservicecapstone.controllers;


import com.shopkart.productservicecapstone.models.Product;
import com.shopkart.productservicecapstone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/products")
    public void createProduct(){

    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long productId){
        return productService.getProduct(productId);
    }

}
