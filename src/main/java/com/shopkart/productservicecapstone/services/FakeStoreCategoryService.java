package com.shopkart.productservicecapstone.services;

import com.shopkart.productservicecapstone.dtos.FakeStoreCategoryResponseDto;
import com.shopkart.productservicecapstone.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreCategoryService implements  CategoryService{
    private RestTemplate restTemplate;
    public FakeStoreCategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Category> findAll() {
        String[] cateoriesList = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", String[].class).getBody();
        List<Category> categories = Arrays.asList(cateoriesList).stream().map(cateStr->new FakeStoreCategoryResponseDto(cateStr).toCategory()).toList();
        return categories;
    }
}
