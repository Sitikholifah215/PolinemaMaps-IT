package com.example.ulfa.itmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ulfa.itmaps.Models.UpdateUserResponse;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sunting_Activity extends AppCompatActivity {

    TextView EdNim, EdNama;
    EditText EdPaass;
    LinearLayout btn_simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunting_);
        EdNim =(TextView)findViewById(R.id.nim_profil);
        EdNama = (TextView)findViewById(R.id.nama_profil);
        EdPaass =(EditText)findViewById(R.id.password_profil);
        btn_simpan =(LinearLayout)findViewById(R.id.linier_Sunting);

        Intent i = getIntent();
        String namaUser = i.getStringExtra("nama_user");
        String usernameNim = i.getStringExtra("username");
        String passwordNim = i.getStringExtra("password");
        EdNama.setText(namaUser);
        EdNim.setText(usernameNim);
        EdPaass.setText(passwordNim);


        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),profil.class);
                updatePasswordUser();
                i.putExtra("nama_user",namaUser);
                i.putExtra("username",usernameNim);
                i.putExtra("password", passwordNim);
                startActivity(i);
                finish();

            }
        });


    }

    public void updatePasswordUser(){
        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<UpdateUserResponse> updatePasswordUser = mApiInterface.updatePasswordUser(EdNim.getText().toString(),EdPaass.getText().toString());
        updatePasswordUser.enqueue(new Callback<UpdateUserResponse>() {
            @Override
            public void onResponse(Call<UpdateUserResponse> call, Response<UpdateUserResponse> response) {
                String status = response.body().getStatus();
                if (status.equals("success")){
                    Toast.makeText(getApplicationContext(),"Update berhasil",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getApplicationContext(),"Update gagal",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdateUserResponse> call, Throwable t) {

            }
        });

    }
}
