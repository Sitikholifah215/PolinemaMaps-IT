package com.example.ulfa.itmaps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ulfa.itmaps.Adapter.Rec_slide_adapter;
import com.example.ulfa.itmaps.Models.ResultRuangan;
import com.example.ulfa.itmaps.Models.RuanganModel;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity_Home extends AppCompatActivity {
    RecyclerView mSlideview;
    RecyclerView.LayoutManager laymanager;
    RecyclerView.Adapter madapter;
    Context mContext;
    ApiInterface mApiInterface;
    CardView chat, ruangan, gedung;
    ImageView profile;
    TextView NamaUser;
    private String id_user, username,nama_user, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__home);
        initRecyclerview_SlideImage();
        NamaUser = (TextView)findViewById(R.id.idNamaUser);
        Intent i = getIntent();
        String namaUser = i.getStringExtra("nama_user");
        NamaUser.setText(namaUser);



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
                Intent i = new Intent(MainActivity_Home.this,MainActivity_Gedung.class);
                startActivity(i);
            }
        });

        profile = (ImageView)findViewById(R.id.icUser);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_Home.this, profil.class);
                i.putExtra("id_user", id_user);
                i.putExtra("username",username);
                i.putExtra("nama_user", nama_user);
                i.putExtra("password",password);
                startActivity(i);
            }
        });


    }
    private void  initRecyclerview_SlideImage(){
        mContext = getApplicationContext();
        mSlideview = (RecyclerView) findViewById(R.id.RecyclerviewhorizontalSlide);
        laymanager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        mSlideview.setLayoutManager(laymanager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultRuangan> mResultRuangan = mApiInterface.getRuangan();
        mResultRuangan.enqueue(new Callback<ResultRuangan>() {
            @Override
            public void onResponse(Call<ResultRuangan> call, Response<ResultRuangan> response) {
                Log.d("Get Ruangan Image", response.body().getStatus());
                List<RuanganModel> listRuanganImage = response.body().getResult();
                madapter = new Rec_slide_adapter(listRuanganImage);
                mSlideview.setAdapter(madapter);
            }

            @Override
            public void onFailure(Call<ResultRuangan> call, Throwable t) {
                Log.d("Get Ruangan Image",t.getMessage());
            }
        });

//            madapter = new Rec_slide_adapter(mImagesUrl,this);
//            recyclerViewww.setAdapter(madapter);

    }

//
//    public void GetProfil(){
//        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<ResponseDelete> updateNote = mApiInterface.updateNote(judul,edNote.getText().toString());
//        updateNote.enqueue(new Callback<ResponseDelete>() {
//            @Override
//            public void onResponse(Call<ResponseDelete> call, Response<ResponseDelete> response) {
//                String status = response.body().getStatus();
//                if (status.equals("sukses")){
//                    Toast.makeText(getApplicationContext(),"Update berhasil",Toast.LENGTH_SHORT).show();
//                    finish();
//                }else {
//                    Toast.makeText(getApplicationContext(),"Update gagal",Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseDelete> call, Throwable t) {
//
//            }
//        });
//
//    }
}
