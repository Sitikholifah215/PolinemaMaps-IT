package com.example.ulfa.itmaps.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.1.41:8080/RestApi/index.php/";
    public static final String BASE_IMAGE_RUANGAN = "http://192.168.1.41:8080/RestApi/application/upload_ruangan/";
    public static final String BASE_IMAGE_GEDUNG = "http://192.168.1.41:8080/RestApi/application/upload_gedung/";
    public static final String BASE_IMAGE_USER = "http://192.168.1.41:8080/RestApi/application/upload_user/";

    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
