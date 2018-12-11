package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("id_user")
    private String id_user;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("nama_user")
    private String nama_user;
    @SerializedName("photo_user")
    private String photo_user;
    private String action;

    public UserModel(){}

    public UserModel(String id_user, String username, String password, String nama_user, String photo_user, String action) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.nama_user = nama_user;
        this.photo_user = photo_user;
        this.action = action;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getPhoto_user() {
        return photo_user;
    }

    public void setPhoto_user(String photo_user) {
        this.photo_user = photo_user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
