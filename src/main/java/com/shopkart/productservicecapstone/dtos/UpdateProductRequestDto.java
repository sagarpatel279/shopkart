package com.shopkart.productservicecapstone.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequestDto {
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
