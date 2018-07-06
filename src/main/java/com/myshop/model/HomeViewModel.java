package com.myshop.model;

import java.util.List;

public class HomeViewModel {
    public User user;
    public List<Product> products;
    public List<ProductViewModel> boughtProducts;

    public List<ProductViewModel> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<ProductViewModel> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public HomeViewModel(User user, List<Product> products, List<ProductViewModel> boughtProducts) {

        this.user = user;
        this.products = products;
        this.boughtProducts = boughtProducts;
    }
}
