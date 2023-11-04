package com.example.fruitapp.model;

public class Fruit {
    private int Id;
    private String Name;
    private int Price;
    private String PhotoURL;
    private String AuditedUser;

    public Fruit(int id, String name, int price, String photoURL, String auditedUser) {
        Id = id;
        Name = name;
        Price = price;
        PhotoURL = photoURL;
        AuditedUser = auditedUser;
    }

    public Fruit() {
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

    public String getPhotoURL() {
        return PhotoURL;
    }

    public void setPhotoURL(String photoURL) {
        PhotoURL = photoURL;
    }

    public String getAuditedUser() {
        return AuditedUser;
    }

    public void setAuditedUser(String auditedUser) {
        AuditedUser = auditedUser;
    }
}
