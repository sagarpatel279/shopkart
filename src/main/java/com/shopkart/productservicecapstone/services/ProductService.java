package com.shopkart.productservicecapstone.services;

import com.shopkart.productservicecapstone.models.Product;

public interface ProductService {
    Product createProduct();
    Product getProduct(Long productId);
}
