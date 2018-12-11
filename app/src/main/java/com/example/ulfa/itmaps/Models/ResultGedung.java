package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultGedung {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<GedungModel> result = new ArrayList<GedungModel>();
    @SerializedName("message")
    private String message;

    public ResultGedung() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GedungModel> getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
