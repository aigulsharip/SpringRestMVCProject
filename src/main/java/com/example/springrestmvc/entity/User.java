package com.example.springrestmvc.entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private String gender;

    private String phone;

    public User(Integer id, String name, String email, String gender, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
