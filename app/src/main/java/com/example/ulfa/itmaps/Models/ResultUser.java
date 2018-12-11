package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultUser {
    @SerializedName("status")
    private String status;

    @SerializedName("result") private User user;

//    @SerializedName("message")
//    private String message;
//
//    @SerializedName("data")
//    private List<UserModel> data = new ArrayList<UserModel>();

    public ResultUser(String status , User user) {
        this.status = status;
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
