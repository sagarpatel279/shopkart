package com.shopkart.productservicecapstone.dtos;

import com.shopkart.productservicecapstone.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCategoryResponseDto {
    private String categoryName;
    private static long id=1;
    public FakeStoreCategoryResponseDto(String categoryName) {
        this.categoryName = categoryName;
    }
    public Category toCategory() {
        Category category = new Category();
        category.setName(categoryName);
        category.setId(id++);
        return category;
    }
}
