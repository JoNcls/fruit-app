package com.example.fruitapp.model;

public class ApplicationKey {
    private String Id;
    private int UserId;

    public ApplicationKey(String id, int userId) {
        Id = id;
        UserId = userId;
    }

    public ApplicationKey() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
