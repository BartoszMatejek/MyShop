package com.myshop.model;

import javax.validation.constraints.Email;

public class LoginUser {

    @Email(message = "Nieprawidłowy format adresu e-mail")
    String email;

    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}