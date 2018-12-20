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
import com.example.ulfa.itmaps.Models.User;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;
import com.example.ulfa.itmaps.listener.ClickListener;
import com.example.ulfa.itmaps.listener.RecyclerTouchListener;

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
    ImageView profile, a;
    TextView NamaUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__home);
        initRecyclerview_SlideImage();
        NamaUser = (TextView)findViewById(R.id.idNamaUser);
        Intent i = getIntent();
        String namaUser = i.getStringExtra("nama_user");
        String usernameNim = i.getStringExtra("username");
        String passwordNim = i.getStringExtra("password");

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
                //User user = response.body().getUser();
                Intent i = new Intent(MainActivity_Home.this, profil.class);
                i.putExtra("nama_user",namaUser);
                i.putExtra("username",usernameNim);
                i.putExtra("password", passwordNim);
                startActivity(i);

                //i.putExtra("username", user.getUsername());
//                i.putExtra("id_user", id_user);
//                i.putExtra("username",username);
//                i.putExtra("nama_user", nama_user);
//                i.putExtra("password",password);

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
                mSlideview.addOnItemTouchListener(new RecyclerTouchListener(mContext, mSlideview, new ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        RuanganModel ruanganm = listRuanganImage.get(position);
                        Toast.makeText(mContext, "KD Ruangan : "+ruanganm.getKd_ruangan(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(mContext, detail_Ruangan_Activity.class);
                        i.putExtra("kd_ruang", ruanganm.getKd_ruangan());
                        i.putExtra("nm_ruangan", ruanganm.getNm_ruangan());
                        i.putExtra("kd_gedung",ruanganm.getKd_gedung());
                        i.putExtra("nm_gedung",ruanganm.getNm_gedung());
                        i.putExtra("photo_ruangan",ruanganm.getPhoto_ruangan());
                        i.putExtra("latitude",ruanganm.getLatitude());
                        i.putExtra("longitude",ruanganm.getLongitude());
                        startActivity(i);
                    }

                    @Override
                    public void onLongClick(View view, int posi) {

                    }
                }));
            }

            @Override
            public void onFailure(Call<ResultRuangan> call, Throwable t) {
                Log.d("Get Ruangan Image",t.getMessage());
            }
        });

//            madapter = new Rec_slide_adapter(mImagesUrl,this);
//            recyclerViewww.setAdapter(madapter);

    }


}
