package com.myshop.model;

public class ProductViewModel {

    public Product product;
    public BoughtProduct boughtProduct;

    public ProductViewModel(Product product, BoughtProduct boughtProduct) {
        this.product = product;
        this.boughtProduct = boughtProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BoughtProduct getBoughtProduct() {
        return boughtProduct;
    }

    public void setBoughtProduct(BoughtProduct boughtProduct) {
        this.boughtProduct = boughtProduct;
    }
}
