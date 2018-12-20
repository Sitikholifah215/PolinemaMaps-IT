package com.example.ulfa.itmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ulfa.itmaps.Models.ResultUser;
import com.example.ulfa.itmaps.Models.User;
import com.example.ulfa.itmaps.Rest.ApiClient;
import com.example.ulfa.itmaps.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profil extends AppCompatActivity {

    LinearLayout sunting , logout;
    TextView usernameq,namaq,passwordq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        //usernameNim.setText(namaUser);

        sunting = (LinearLayout)findViewById(R.id.linier_Sunting);
        logout = (LinearLayout)findViewById(R.id.linier_keluar);

        usernameq = (TextView)findViewById(R.id.nim_profil);
        namaq = (TextView)findViewById(R.id.nama_profil);
        passwordq = (TextView)findViewById(R.id.password_profil);
//        edNote.setText(i.getStringExtra("note"));
        Intent i = getIntent();
        String namaUser = i.getStringExtra("nama_user");
        String usernameNim = i.getStringExtra("username");
        String passwordNim = i.getStringExtra("password");
        namaq.setText(namaUser);
        usernameq.setText(usernameNim);
        passwordq.setText(passwordNim);


        //onResume();


        sunting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(profil.this, sunting_Activity.class);
                i.putExtra("nama_user",namaUser);
                i.putExtra("username",usernameNim);
                i.putExtra("password", passwordNim);
                startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(profil.this, MainActivity_login.class);
                startActivity(i);

            }
        });
    }
    protected void onStart() {
        super.onStart();
        //super.onResume();
        loadData();
    }


    private void loadData()
    {
        Intent i = getIntent();
        String namaUser = i.getStringExtra("nama_user");
        String usernameNim = i.getStringExtra("username");
        String passwordNim = i.getStringExtra("password");
        namaq.setText(namaUser);
        usernameq.setText(usernameNim);
        passwordq.setText(passwordNim);

    }
}
