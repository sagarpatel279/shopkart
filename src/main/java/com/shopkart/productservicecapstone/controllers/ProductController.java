package com.shopkart.productservicecapstone.controllers;


import com.shopkart.productservicecapstone.dtos.CreateFakeStoreProductRequestDto;
import com.shopkart.productservicecapstone.models.Product;
import com.shopkart.productservicecapstone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Get all products
//Get all categories
//Update a product
//Delete a product
//Get products in a specific category
@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateFakeStoreProductRequestDto requestDto){
        return productService.createProduct(requestDto.getTitle(),requestDto.getPrice(),requestDto.getCategory(), requestDto.getDescription(), requestDto.getImage());
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

}
