package com.example.fruitapp.model;

public class Cart {
    private int ID;
    private String Username;
    private int FruitID;
    private int Quantity;

    public Cart() {
    }

    public Cart(int ID, String username, int fruitID, int quantity) {
        this.ID = ID;
        this.Username = username;
        this.FruitID = fruitID;
        this.Quantity = quantity;
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

    public int getFruitID() {
        return FruitID;
    }

    public void setFruitID(int fruitID) {
        this.FruitID = fruitID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
