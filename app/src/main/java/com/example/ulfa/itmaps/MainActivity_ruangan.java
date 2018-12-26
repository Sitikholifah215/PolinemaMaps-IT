package com.example.ulfa.itmaps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ulfa.itmaps.Adapter.Rec_slide_adapter;
import com.example.ulfa.itmaps.Adapter.RuanganViewAdapter;
import com.example.ulfa.itmaps.Models.ResultRuangan;
import com.example.ulfa.itmaps.Models.RuanganModel;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;
import com.example.ulfa.itmaps.listener.ClickListener;
import com.example.ulfa.itmaps.listener.RecyclerTouchListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MainActivity_ruangan extends AppCompatActivity {
    RecyclerView mRuanganview;
    RecyclerView.LayoutManager mlayoutm;
    RecyclerView.Adapter mAdapter;
    Context mContext;
    ApiInterface mApiInterface;
    ListView pencarian_ruangan;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ruangan);
       initRecyclerRuangan();
//
//        pencarian_ruangan = (ListView) findViewById(R.id.rv_main);
//
//        ArrayList<String> arrayRuangan = new ArrayList<>();
//        //iki seng error gak paham nyeluk e
//        arrayRuangan.addAll(Arrays.asList(getResources().getStringArray(R.array.cari_Ruangan)));
//
//        adapter = new ArrayAdapter<String>(
//                MainActivity_ruangan.this,
//                android.R.layout.simple_list_item_1,
//                arrayRuangan
//        );
//        pencarian_ruangan.setAdapter(adapter);
    }


    private void initRecyclerRuangan() {
        mContext = getApplicationContext();
        mRuanganview = (RecyclerView) findViewById(R.id.rv_main);
        mlayoutm = new LinearLayoutManager(mContext);
        mRuanganview.setLayoutManager(mlayoutm);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultRuangan> mRuanganView = mApiInterface.getRuangan();
        mRuanganView.enqueue(new Callback<ResultRuangan>() {
            @Override
            public void onResponse(Call<ResultRuangan> call, Response<ResultRuangan> response) {
                Log.d("Get Ruangan", response.body().getStatus());
                List<RuanganModel> listRuanganView = response.body().getResult();
                mAdapter = new RuanganViewAdapter(listRuanganView);
                mRuanganview.setAdapter(mAdapter);
                mRuanganview.addOnItemTouchListener(new RecyclerTouchListener(mContext, mRuanganview, new ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        RuanganModel ruanganm = listRuanganView.get(position);
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
                Log.d("Get Ruangan",t.getMessage());
            }
        });
    }
}
