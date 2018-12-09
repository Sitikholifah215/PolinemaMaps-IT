package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultRuangan {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<RuanganModel> result = new ArrayList<RuanganModel>();
    @SerializedName("message")
    private String message;

    public ResultRuangan() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RuanganModel> getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
