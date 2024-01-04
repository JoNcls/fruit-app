package com.example.fruitapp.model;

import com.google.gson.annotations.SerializedName;

public class Cart {
    private int ID;
    private String Username;
    private String fruitName;
    private int Quantity;

    public Cart() {
    }

    public Cart(int ID, String username, String fruitName, int quantity) {
        this.ID = ID;
        Username = username;
        this.fruitName = fruitName;
        Quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
