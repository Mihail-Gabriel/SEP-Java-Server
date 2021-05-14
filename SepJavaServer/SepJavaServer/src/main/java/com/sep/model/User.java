package com.sep.model;

import java.io.Serializable;


public class User implements Serializable {

    private String name;
    private String password;
    private String email;
    private String address;
    private String telephoneNo;

    public User(String name, String password, String email, String address, String telephoneNo) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.telephoneNo = telephoneNo;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }
}
