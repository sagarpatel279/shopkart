package com.shopkart.productservicecapstone.dtos;

import com.shopkart.productservicecapstone.models.Category;
import com.shopkart.productservicecapstone.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDetailsDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        Category category = new Category();
        category.setId(123L);
        category.setName("Mobile");
        product.setCategory(category);
        return product;
    }
}
