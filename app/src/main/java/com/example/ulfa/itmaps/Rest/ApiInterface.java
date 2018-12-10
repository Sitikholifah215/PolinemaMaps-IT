package com.example.ulfa.itmaps.Rest;

import com.example.ulfa.itmaps.Models.ResultRuangan;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("ruangan/ruangan")
    Call<ResultRuangan> getRuangan();

//    @GET("ruangan/gedung")
//    Call<>
}
