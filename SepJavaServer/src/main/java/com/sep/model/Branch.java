package com.sep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Branch implements Serializable {
    private int branchId;
    private String theme;
    private String branchName;
    private String city;


    public Branch(int branchId, String theme, String branchName, String city) {
        this.branchId = branchId;
        this.theme = theme;
        this.branchName = branchName;
        this.city = city;

    }

    public Branch() {
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

}
