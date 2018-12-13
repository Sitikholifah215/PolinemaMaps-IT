package com.example.ulfa.itmaps.Rest;

import com.example.ulfa.itmaps.Models.ResultDetailG;
import com.example.ulfa.itmaps.Models.ResultGedung;
import com.example.ulfa.itmaps.Models.ResultRuangan;
import com.example.ulfa.itmaps.Models.ResultUser;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("ruangan/login")
    Call<ResultUser> loginRequest(@Field("username")String username);

    @GET("ruangan/ruangan")
    Call<ResultRuangan> getRuangan();

    @GET("ruangan/gedung")
    Call<ResultGedung> getGedung();

    @GET("ruangan/detailgedung")
    Call<ResultDetailG> getGedungDetail(@Query("kd_gedung") String gedung);


}
