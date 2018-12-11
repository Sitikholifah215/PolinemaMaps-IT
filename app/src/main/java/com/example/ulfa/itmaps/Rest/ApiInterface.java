package com.example.ulfa.itmaps.Rest;

import com.example.ulfa.itmaps.Models.ResultRuangan;
import com.example.ulfa.itmaps.Models.ResultUser;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("ruangan/login")
    Call<ResultUser> loginRequest(@Field("username")String username);

    @GET("ruangan/ruangan")
    Call<ResultRuangan> getRuangan();

//    @Multipart
//    @POST("ruangan/login")
//    Call<ResultUser> postLogin(@Part("username")RequestBody username,
//                               @Part("password")RequestBody password);
}
