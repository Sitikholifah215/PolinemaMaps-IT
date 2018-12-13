package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

public class ResultDetailG {
    @SerializedName("status")
    private String status;

    @SerializedName("result")
    private GedungModel result;

    public ResultDetailG(String status , GedungModel result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public GedungModel getGedung() {
        return result;
    }

    public void setGedung(GedungModel result) {
        this.result = result;
    }
}

