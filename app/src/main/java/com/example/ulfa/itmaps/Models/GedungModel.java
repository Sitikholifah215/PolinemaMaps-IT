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
    private String latitude;
    @SerializedName("longitude")
    private String longitude;


    public GedungModel(String kd_gedung, String nm_gedung, String photo_gedung, String latitude, String longitude) {
        this.kd_gedung = kd_gedung;
        this.nm_gedung = nm_gedung;
        this.photo_gedung = photo_gedung;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getPhoto_gedung() {
        return photo_gedung;
    }

    public void setPhoto_gedung(String photo_gedung) {
        this.photo_gedung = photo_gedung;
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
}
