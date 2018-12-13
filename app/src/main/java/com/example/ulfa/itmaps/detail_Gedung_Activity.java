package com.example.ulfa.itmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ulfa.itmaps.Models.GedungModel;
import com.example.ulfa.itmaps.Models.ResultDetailG;
import com.example.ulfa.itmaps.Models.ResultGedung;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detail_Gedung_Activity extends AppCompatActivity {
    TextView nama_gedung, kode_gedung;
    ImageView img_gedung;
    Button btnMaps,back_gedung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__gedung_);
        nama_gedung = findViewById(R.id.text_namaGedung);
        img_gedung = findViewById(R.id.img_detail_gedung);
        kode_gedung = findViewById(R.id.textView_kodeGedung);
        back_gedung = findViewById(R.id.btn_BackGedung);
        btnMaps = findViewById(R.id.btn_Maps);
        Intent i = getIntent();
        String nama_gd = i.getStringExtra("nm_gedung");
        String kd_gd = i.getStringExtra("kd_gedung");
        String img_gd = i.getStringExtra("photo_gedung");
        final double latitude = i.getDoubleExtra("latitude",0);
        final double longitude = i.getDoubleExtra("longitude",0);
        nama_gedung.setText(nama_gd);
        kode_gedung.setText(kd_gd);
        Glide.with(getApplicationContext()).load(ApiClient.BASE_IMAGE_GEDUNG+img_gd).into(img_gedung);

        back_gedung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),MainActivity_Gedung.class);
                startActivity(back);
                finish();
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Maps = new Intent(getApplicationContext(),MapsActivity.class);
                Maps.putExtra("latitude",latitude);
                Maps.putExtra("longitude",longitude);
                startActivity(Maps);
            }
        });
    }
}
