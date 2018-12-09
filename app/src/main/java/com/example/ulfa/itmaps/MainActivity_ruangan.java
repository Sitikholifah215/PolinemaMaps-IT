package com.example.ulfa.itmaps;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ulfa.itmaps.Adapter.Rec_slide_adapter;
import com.example.ulfa.itmaps.Models.ResultRuangan;
import com.example.ulfa.itmaps.Models.RuanganModel;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity_ruangan extends AppCompatActivity {
    RecyclerView mRuanganview;
    RecyclerView.LayoutManager mlayoutm;
    RecyclerView.Adapter mAdapter;
    Context mContext;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ruangan);
        initRecyclerRuangan();
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
                mAdapter = new Rec_slide_adapter(listRuanganView);
                mRuanganview.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResultRuangan> call, Throwable t) {
                Log.d("Get Ruangan",t.getMessage());
            }
        });
    }
}
