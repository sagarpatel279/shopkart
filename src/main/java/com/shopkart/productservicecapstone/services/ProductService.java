package com.shopkart.productservicecapstone.services;

import com.shopkart.productservicecapstone.models.Product;

public interface ProductService {
    Product createProduct(String title,double price,String category, String description, String image);
    Product getProduct(Long productId);
}
