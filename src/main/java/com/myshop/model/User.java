package com.myshop.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty(message = "Pole nie może być puste")
    @Email(message = "Nieprawidłowy format adresu e-mail")
    private String email;
    @NotNull
    @NotEmpty(message = "Pole nie może być puste")
    @Size(min = 2,message = "Imię powinno zawierać minimum 2 znaki")
    private String name;
    @NotNull
    @NotEmpty(message = "Pole nie może być puste")
    @Size(min = 2, message = "Nazwisko musi zawierać minimum 2 znaki")
    private String lastName;
    @NotNull
    @NotEmpty(message = "Pole nie może być puste")
    @Size(min = 5,message = "Hasło powinno zawierać minimum 5 znaków")
    private String password;

    @Transient
    private String passwordConf;


    public User(){}

    public User(String name, String lastName, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPasswordConf() {
        return passwordConf;
    }

    public void setPasswordConf(String passwordConf) {
        this.passwordConf = passwordConf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
