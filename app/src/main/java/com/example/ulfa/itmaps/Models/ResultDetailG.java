package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

public class ResultDetailG {
    @SerializedName("status")
    private String status;

    @SerializedName("result")
    private GedungModel gedung;

    public ResultDetailG(String status , GedungModel gedung) {
        this.status = status;
        this.gedung = gedung;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public GedungModel getGedung() {
        return gedung;
    }

    public void setGedung(GedungModel gedung) {
        this.gedung = gedung;
    }
}

