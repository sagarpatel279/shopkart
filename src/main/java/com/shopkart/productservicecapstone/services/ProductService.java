package com.shopkart.productservicecapstone.services;

import com.shopkart.productservicecapstone.exceptions.ProductNotFoundException;
import com.shopkart.productservicecapstone.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(String title,double price,String category, String description, String image);
    Product getProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
}
