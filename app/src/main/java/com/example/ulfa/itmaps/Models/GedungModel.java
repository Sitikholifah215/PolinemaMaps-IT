package com.example.ulfa.itmaps.Models;

import com.google.gson.annotations.SerializedName;

public class GedungModel {
    @SerializedName("kd_gedung")
    private String kd_gedung;
    @SerializedName("nm_gedung")
    private String nm_gedung;
    @SerializedName("photo_gedung")
    private String photo_gedung;
    @SerializedName("latitude")
    private Double latitude;
    @SerializedName("longitude")
    private Double longitude;



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

    public String getPhoto_gedung() {
        return photo_gedung;
    }

    public void setPhoto_gedung(String photo_gedung) {
        this.photo_gedung = photo_gedung;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
