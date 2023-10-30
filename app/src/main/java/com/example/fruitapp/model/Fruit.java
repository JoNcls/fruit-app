package com.example.fruitapp.model;

public class Fruit {
    private int Id;
    private String Name;
    private int Price;
    private String Photo_URL;

    public Fruit(int id, String name, int price, String photo_URL) {
        Id = id;
        Name = name;
        Price = price;
        Photo_URL = photo_URL;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getPhoto_URL() {
        return Photo_URL;
    }

    public void setPhoto_URL(String photo_URL) {
        Photo_URL = photo_URL;
    }
}
