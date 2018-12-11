package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

import java.security.PublicKey;

public class User {
    @SerializedName("id_user") private Integer id_user;
    @SerializedName("username") private String username;
    @SerializedName("password") private  String password;
    @SerializedName("nama_user") private String nama_user;
    @SerializedName("telpon") private  String  telpon;
    @SerializedName("photo_user") private  String photo_user;
    @SerializedName("level") private  String level;

    public User (Integer id_user, String username, String password, String nama_user, String telpon, String photo_user, String level)
    {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.nama_user = nama_user;
        this.telpon = telpon;
        this.photo_user = photo_user;
        this.level = level;
    }

    public Integer getId_user()
    {
        return id_user;
    }
    public void setId_user(Integer id_user)
    {
        this.id_user = id_user;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_user()
    {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getTelpon(){
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getPhoto_user()
    {
        return photo_user;
    }

    public void setPhoto_user(String photo_user) {
        this.photo_user = photo_user;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
