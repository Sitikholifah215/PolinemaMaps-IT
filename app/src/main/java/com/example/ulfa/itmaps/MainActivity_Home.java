package com.example.ulfa.itmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class MainActivity_Home extends AppCompatActivity {
    private RecyclerView.LayoutManager laymanager;
    private RecyclerView.Adapter madapter;
    CardView chat, ruangan, gedung;
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__home);

        chat = (CardView)findViewById(R.id.menu_chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_Home.this,PesanActivity.class);
                startActivity(i);
            }
        });

        ruangan = (CardView)findViewById(R.id.menu_ruangan);
        ruangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_Home.this,MainActivity_ruangan.class);
                startActivity(i);
            }
        });

        gedung = (CardView)findViewById(R.id.menu_gedung);
        gedung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_Home.this,MainActivity_gedung.class);
                startActivity(i);
            }
        });

        profile = (ImageView)findViewById(R.id.icUser);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_Home.this, profil.class);
                startActivity(i);
            }
        });


    }
    private void  initRecyclerview_SlideImage(){

        laymanager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerViewww = findViewById(R.id.RecyclerviewhorizontalSlide);
        recyclerViewww.setLayoutManager(laymanager);

//            madapter = new Rec_slide_adapter(mImagesUrl,this);
//            recyclerViewww.setAdapter(madapter);

    }
}
