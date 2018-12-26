package com.example.ulfa.itmaps;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ulfa.itmaps.Adapter.ChatRuanganAdapter;
import com.example.ulfa.itmaps.Models.ResultCariRuangan;
import com.example.ulfa.itmaps.Models.ResultUser;
import com.example.ulfa.itmaps.Models.RuanganModel;
import com.example.ulfa.itmaps.Models.User;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PesanActivity extends AppCompatActivity {
    Button btn_send;
    EditText inputKode;
    //TextView coba;

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);


        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewChat);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //coba = (TextView)findViewById(R.id.textView5);
        inputKode = (EditText)findViewById(R.id.editText);
        btn_send = (Button)findViewById(R.id.buttonSend);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               Intent i = new Intent(getApplicationContext(), Main2Activity_perbaikan.class);
//               startActivity(i);

                ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);

                Call<ResultCariRuangan> mCari =  mApiInterface.ruanganRequest(inputKode.getText().toString());

                mCari.enqueue(new Callback<ResultCariRuangan>() {
                    @Override
                    public void onResponse(Call<ResultCariRuangan> call, Response<ResultCariRuangan> response) {
                        Log.d("Get Ruangan",response.body().getStatus());
                        List<RuanganModel> resultCariRuanganList = response.body().getResult();
                        mAdapter = new ChatRuanganAdapter(resultCariRuanganList);
                        mRecyclerView.setAdapter(mAdapter);

                       // String status = response.body().getStatus();
//                        if (status.equals("success"))
//                        {
////                            RuanganModel ruangCari = response.body().getKd_ruangan();
////                            Intent i = getIntent();
////                            String cobaa = i.getStringExtra("kd_ruangan");
////                            coba.setText(cobaa);
//
//
////                            Intent i = new Intent(MainActivity_login.this, MainActivity_Home.class);
////                            i.putExtra("username", user.getUsername());
////                            i.putExtra("nama_user", user.getNama_user());
////                            i.putExtra("password", user.getPassword());
////
////                            Toast.makeText(getApplicationContext(),"Pencarian berhasil",Toast.LENGTH_SHORT).show();
////                            startActivity(i);
////                            finish();
//                        }
//                        else
//                        {
//                            Toast.makeText(getApplicationContext(), "Maaf kode yang anda masukan salah!", Toast.LENGTH_LONG).show();
//                        }
                    }

                    @Override
                    public void onFailure(Call<ResultCariRuangan> call, Throwable t) {
                        //Toast.makeText(getApplicationContext(),"fail search", Toast.LENGTH_SHORT).show();
                        Log.d("Get Ruangan",t.getMessage());

                    }
                });

            }
        });

    }
}
