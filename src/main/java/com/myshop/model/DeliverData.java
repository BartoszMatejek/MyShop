package com.myshop.model;


public class DeliverData {
    private String city;
    private String street;
    private int flat;
    private String postCode;

    public DeliverData(){

    }
    public DeliverData(String city, String street, int flat, String postCode) {
        this.city = city;
        this.street = street;
        this.flat = flat;
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
