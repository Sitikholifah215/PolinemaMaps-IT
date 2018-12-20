package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

public class UpdateUserResponse {

    @SerializedName("status") String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
