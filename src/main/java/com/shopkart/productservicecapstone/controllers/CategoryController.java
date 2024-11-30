package com.shopkart.productservicecapstone.controllers;

import com.shopkart.productservicecapstone.models.Category;
import com.shopkart.productservicecapstone.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @GetMapping("products/categories")
//    public List<Category> getAllCategories() {
//        return categoryService.findAll();
//    }
}
