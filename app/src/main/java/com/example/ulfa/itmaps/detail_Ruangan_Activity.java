package com.example.ulfa.itmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ulfa.itmaps.Rest.ApiClient;

public class detail_Ruangan_Activity extends AppCompatActivity {
    TextView kd_ruangan, nm_ruangan;
    ImageView img_ruangan;
    Button btnMapsR, btnBackR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__ruangan_);
        kd_ruangan = findViewById(R.id.textView_kodeGedung);
        nm_ruangan = findViewById(R.id.text_nama_ruangan);
        img_ruangan = findViewById(R.id.img_detail_ruangan);
        btnBackR = findViewById(R.id.btn_Back_ruangan);
        btnMapsR = findViewById(R.id.btnMapsRuangan);

        Intent i = getIntent();
        String kd_r = i.getStringExtra("kd_ruangan");
        String nm_r = i.getStringExtra("nm_ruangan");
        String kd_g = i.getStringExtra("kd_gedung");
        String nm_g = i.getStringExtra("nm_gedung");
        String img_r = i.getStringExtra("photo_ruangan");
        final double latitude = i.getDoubleExtra("latitude",0);
        final double longitude = i.getDoubleExtra("longitude",0);

        kd_ruangan.setText(kd_r);
        nm_ruangan.setText(nm_r);
        Glide.with(getApplicationContext()).load(ApiClient.BASE_IMAGE_RUANGAN+img_r).into(img_ruangan);

        btnBackR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(), MainActivity_ruangan.class);
                startActivity(back);
                finish();
            }
        });

        btnMapsR.setOnClickListener(new View.OnClickListener() {
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
