package com.example.fruitapp.model;

public class User {
    private int Id;
    private String Username;
    private int RoleId;
    private String Name;
    private String Email;
    private String Password;

    public User(int id, String username, int roleId, String name, String email, String password) {
        Id = id;
        Username = username;
        RoleId = roleId;
        Name = name;
        Email = email;
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
