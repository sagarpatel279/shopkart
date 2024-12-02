package com.shopkart.productservicecapstone.controllers;


import com.shopkart.productservicecapstone.dtos.CreateFakeStoreProductRequestDto;
import com.shopkart.productservicecapstone.exceptions.ProductNotFoundException;
import com.shopkart.productservicecapstone.models.Category;
import com.shopkart.productservicecapstone.models.Product;
import com.shopkart.productservicecapstone.services.CategoryService;
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
    private CategoryService categoryService;
    @Autowired
    public ProductController(ProductService productService,CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateFakeStoreProductRequestDto requestDto){
        return productService.createProduct(requestDto.getTitle(),requestDto.getPrice(),requestDto.getCategory(), requestDto.getDescription(), requestDto.getImage());
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long productId) throws ProductNotFoundException {
        return productService.getProduct(productId);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/categories")
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }
    @GetMapping("/products/products/categories/{name}")
    public List<Product> getProductsByCategory(@PathVariable("name") String categoryName){
        return productService.getProductsByCategory(categoryName);
    }
}
