package com.example.fruitapp.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class Fruit {
    @SerializedName("id")
    private int Id;
    @SerializedName("name")
    private String Name;
    @SerializedName("price")
    private int Price;
    @SerializedName("fruitImage")
    private String PhotoURL;
    @SerializedName("audited_user")
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

    public void printLog(){
        Log.d("QiuQiu2", "ID: " + String.valueOf(Id));
        Log.d("QiuQiu2", "Name: " + Name);
        Log.d("QiuQiu2", "Price: " + String.valueOf(Price));
        Log.d("QiuQiu2", "Photo URL: " + PhotoURL);
        Log.d("QiuQiu2", "AuditedUser: " + AuditedUser);
    }
}
