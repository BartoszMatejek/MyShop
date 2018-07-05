package com.myshop.Model;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BoughtProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private long productId;

    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BoughtProduct(){}

    public BoughtProduct(int id, long productId) {
        this.id = id;
        this.productId = productId;
    }

    public BoughtProduct(long productId, String date, long userId) {
        this.productId = productId;
        this.date = date;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
