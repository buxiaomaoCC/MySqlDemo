package com.example.demoww.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "main_date")
public class DateEntify {
    @Id
    @GeneratedValue
    private int dId;
    private String dName;
    private String dNum;
    private String dPrice;
    private String dAdress;

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdNum() {
        return dNum;
    }

    public void setdNum(String dNum) {
        this.dNum = dNum;
    }

    public String getdPrice() {
        return dPrice;
    }

    public void setdPrice(String dPrice) {
        this.dPrice = dPrice;
    }

    public String getdAdress() {
        return dAdress;
    }

    public void setdAdress(String dAdress) {
        this.dAdress = dAdress;
    }
}
