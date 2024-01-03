package com.example.fruitapp.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class Fruit {
    @SerializedName("id")
    private int ID;
    @SerializedName("productGroupCode")
    private String Code;
    @SerializedName("product")
    private String Name;
    @SerializedName("price")
    private int Price;

    public Fruit() {
    }

    public Fruit(int ID, String code, String name, int price) {
        this.ID = ID;
        this.Code = code;
        this.Name = name;
        this.Price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        this.Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }
}
