package com.example.ulfa.itmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ulfa.itmaps.Models.GedungModel;
import com.example.ulfa.itmaps.Models.ResultDetailG;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detail_Gedung_Activity extends AppCompatActivity {
    TextView nama_gedung;
    ImageView img_gedung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__gedung_);
        Intent i = getIntent();
//        HashMap<String, String> param = new HashMap<>();
//        param.put("kd_gedung", i.getStringExtra("kd_gedung"));
        nama_gedung = findViewById(R.id.textView_namaGedung);
        img_gedung = findViewById(R.id.img_detail_gedung);
//        nama_gedung.setText(i.getStringExtra("kd_gedung"));
        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultDetailG> detailG = mApiInterface.getGedungDetail(i.getStringExtra("kd_gedung"));
        detailG.enqueue(new Callback<ResultDetailG>() {
            @Override
            public void onResponse(Call<ResultDetailG> call, Response<ResultDetailG> response) {
//                Log.d("Get Gedung", response.body().getStatus());
                GedungModel res = response.body().getGedung();
                nama_gedung.setText(res.getNm_gedung());
                Glide.with(getApplicationContext()).load(ApiClient.BASE_IMAGE_GEDUNG+res.getPhoto_gedung()).into(img_gedung);
            }

            @Override
            public void onFailure(Call<ResultDetailG> call, Throwable t) {

            }
        });
    }
}
