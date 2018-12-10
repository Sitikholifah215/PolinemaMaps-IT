package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

public class RuanganModel {
    @SerializedName("kd_ruangan")
    private String kd_ruangan;
    @SerializedName("nm_ruangan")
    private String nm_ruangan;
    @SerializedName("kd_gedung")
    private String kd_gedung;
    @SerializedName("nm_gedung")
    private String nm_gedung;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("photo_ruangan")
    private String photo_ruangan;

    public RuanganModel(){}

    public RuanganModel(String kd_ruangan, String nm_ruangan, String kd_gedung, String nm_gedung, String latitude, String longitude, String photo_ruangan) {
        this.kd_ruangan = kd_ruangan;
        this.nm_ruangan = nm_ruangan;
        this.kd_gedung = kd_gedung;
        this.nm_gedung = nm_gedung;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photo_ruangan = photo_ruangan;
    }

    public String getKd_ruangan() {
        return kd_ruangan;
    }

    public void setKd_ruangan(String kd_ruangan) {
        this.kd_ruangan = kd_ruangan;
    }

    public String getNm_ruangan() {
        return nm_ruangan;
    }

    public void setNm_ruangan(String nm_ruangan) {
        this.nm_ruangan = nm_ruangan;
    }

    public String getKd_gedung() {
        return kd_gedung;
    }

    public void setKd_gedung(String kd_gedung) {
        this.kd_gedung = kd_gedung;
    }

    public String getNm_gedung() {
        return nm_gedung;
    }

    public void setNm_gedung(String nm_gedung) {
        this.nm_gedung = nm_gedung;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhoto_ruangan() {
        return photo_ruangan;
    }

    public void setPhoto_ruangan(String photo_ruangan) {
        this.photo_ruangan = photo_ruangan;
    }
}
