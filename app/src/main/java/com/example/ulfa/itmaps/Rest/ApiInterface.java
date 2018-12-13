package com.example.ulfa.itmaps.Rest;

import com.example.ulfa.itmaps.Models.GedungModel;
import com.example.ulfa.itmaps.Models.ResultDetailG;
import com.example.ulfa.itmaps.Models.ResultGedung;
import com.example.ulfa.itmaps.Models.ResultRuangan;
import com.example.ulfa.itmaps.Models.ResultUser;
import com.example.ulfa.itmaps.Models.User;

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
    Call<ResultUser> loginRequest(@Field("username")String username,
                                  @Field("password") String password);


    @GET("ruangan/ruangan")
    Call<ResultRuangan> getRuangan();

    @GET("ruangan/gedung")
    Call<ResultGedung> getGedung();


    @FormUrlEncoded
    @POST("ruangan")
    Call<User> tampilProfile (@Field("id_user") Integer id_user,
                              @Field("username") String username,
                              @Field("password") String password,
                              @Field("nama_user") String nama_user,
                              @Field("photo_user") String photo_user);

//    @Multipart
//    @POST("ruangan/login")
//    Call<ResultUser> postLogin(@Part("username")RequestBody username,
//                               @Part("password")RequestBody password);

//    @Multipart
//    @POST("ruangan/login")
//    Call<ResultUser> postLogin(@Part("username")RequestBody username,
//                               @Part("password")RequestBody password);

//    @GET("ruangan/detailgedung")
//    Call<ResultDetailG> kd_gedung(@Query("kd_gedung") String kd_gedung);


}
