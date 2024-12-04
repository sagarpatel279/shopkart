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
        this.title=title!=null?title:this.title;
    }
    public void setOrDefaultDescription(String description){
        this.description=description!=null?description:this.description;
    }
    public void setOrDefaultPrice(double price){
        this.price=price!=0?price:this.price;
    }
    public void setOrDefaultImageUrl(String imageUrl){
        this.imageUrl=imageUrl!=null?imageUrl:this.imageUrl;
    }
    public void setOrDefaultCategory(Category category){
        this.category=category!=null?category:this.category;
    }
}
