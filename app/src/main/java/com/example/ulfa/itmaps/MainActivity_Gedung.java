package com.example.ulfa.itmaps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ulfa.itmaps.Adapter.GedungViewAdapter;
import com.example.ulfa.itmaps.Models.GedungModel;
import com.example.ulfa.itmaps.Models.ResultGedung;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;
import com.example.ulfa.itmaps.listener.ClickListener;
import com.example.ulfa.itmaps.listener.RecyclerTouchListener;

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
        initRecyclerGedung();
    }

    private void initRecyclerGedung() {
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
                mGedungview.addOnItemTouchListener(new RecyclerTouchListener(mContext, mGedungview, new ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        GedungModel gedungm = listGedungView.get(position);
                        Toast.makeText(mContext, "KD Gedung : "+gedungm.getKd_gedung(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(mContext, detail_Gedung_Activity.class);
                        i.putExtra("kd_gedung",gedungm.getKd_gedung());
                        i.putExtra("nm_gedung",gedungm.getNm_gedung());
                        i.putExtra("photo_gedung",gedungm.getPhoto_gedung());
                        i.putExtra("latitude",gedungm.getLatitude());
                        i.putExtra("longitude",gedungm.getLongitude());
                        startActivity(i);
                    }

                    @Override
                    public void onLongClick(View view, int posi) {

                    }
                }));
            }

            @Override
            public void onFailure(Call<ResultGedung> call, Throwable t) {
                Log.d("Get Gedung",t.getMessage());
            }
        });
    }
}
