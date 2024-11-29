package com.shopkart.productservicecapstone.services;

import com.shopkart.productservicecapstone.dtos.FakeStoreProductDetailsDto;
import com.shopkart.productservicecapstone.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public Product getProduct(Long productId) {
        FakeStoreProductDetailsDto fakeStoreDto=restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductDetailsDto.class);
        return fakeStoreDto.toProduct();
    }
}
