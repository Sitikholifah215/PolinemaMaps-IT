package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultCariRuangan {

    @SerializedName("status") private String status;
    @SerializedName("kd_ruangan") private  RuanganModel kd_ruangan;
    private List<RuanganModel> result = new ArrayList<RuanganModel>();

    public ResultCariRuangan()
    {

    }

    public ResultCariRuangan(String status, RuanganModel kd_ruangan)
    {
        this.status = status;
        this.kd_ruangan = kd_ruangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RuanganModel getKd_ruangan() {
        return kd_ruangan;
    }

    public void setKd_ruangan(RuanganModel kd_ruangan) {
        this.kd_ruangan = kd_ruangan;
    }

    public List<RuanganModel> getResult() {
        return result;
    }

    public void setResult(List<RuanganModel> result) {
        this.result = result;
    }
}
