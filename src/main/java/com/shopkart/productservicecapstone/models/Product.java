package com.shopkart.productservicecapstone.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    public void setOrDefaultTitle(String title){
        this.title = this.title==null? title: this.title;
    }
    public void setOrDefaultDescription(String description){
        this.description = this.description==null? description: this.description;
    }
    public void setOrDefaultPrice(double price){
        this.price = this.price==0? price: this.price;
    }
    public void setOrDefaultImageUrl(String imageUrl){
        this.imageUrl = this.imageUrl==null? imageUrl: this.imageUrl;
    }

}
