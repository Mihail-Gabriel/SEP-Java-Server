package com.sep.model;

import java.io.Serializable;


public class Users implements Serializable {

    private String username;
    private String password;
    private String address;
    private String telephoneNo;
    private String city;
    private String securityLevel;


    public Users(String username, String password, String address, String telephoneNo, String city, String securityLevel) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.telephoneNo = telephoneNo;
        this.city = city;
        this.securityLevel = securityLevel;
    }

    public Users() {

    }


    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String role) {
        this.securityLevel = securityLevel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
