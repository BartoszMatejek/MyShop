package com.myshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private double price;
    @NotEmpty
    private String description;

    private String imageSrc;

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Product(){

    }
    public Product(String date, double price, String description, String imageSrc){
        this.price = price;
        this.description = description;
        this.imageSrc = imageSrc;
    }

    public Product(String date, double price, String description, User user) {
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
