package com.example.ulfa.itmaps;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ulfa.itmaps.Adapter.GedungViewAdapter;
import com.example.ulfa.itmaps.Adapter.Rec_slide_adapter;
import com.example.ulfa.itmaps.Models.GedungModel;
import com.example.ulfa.itmaps.Models.ResultGedung;
import com.example.ulfa.itmaps.Models.ResultRuangan;
import com.example.ulfa.itmaps.Models.RuanganModel;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity_Gedung extends AppCompatActivity {

    RecyclerView mGedungview;
    RecyclerView.LayoutManager mlayoutm;
    RecyclerView.Adapter mAdapter;
    Context mContext;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gedung);
    }

    private void initRecyclerRuangan() {
        mContext = getApplicationContext();
        mGedungview = (RecyclerView) findViewById(R.id.rv_maingedung);
        mlayoutm = new LinearLayoutManager(mContext);
        mGedungview.setLayoutManager(mlayoutm);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultGedung> mGedungView = mApiInterface.getGedung();
        mGedungView.enqueue(new Callback<ResultGedung>() {
            @Override
            public void onResponse(Call<ResultGedung> call, Response<ResultGedung> response) {
                Log.d("Get Gedung", response.body().getStatus());
                List<GedungModel> listGedungView = response.body().getResult();
                mAdapter = new GedungViewAdapter(listGedungView);
                mGedungview.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResultGedung> call, Throwable t) {
                Log.d("Get Gedung",t.getMessage());
            }
        });
    }
}
