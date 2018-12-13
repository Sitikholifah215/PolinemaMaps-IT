package com.example.ulfa.itmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class profil extends AppCompatActivity {

    LinearLayout sunting , logout;
    TextView username,nama,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        sunting = (LinearLayout)findViewById(R.id.linier_Sunting);
        logout = (LinearLayout)findViewById(R.id.linier_keluar);
        Intent i = getIntent();
        username.setText(i.getStringExtra("username"));
        nama.setText(i.getStringExtra("nama_user"));
        password.setText(i.getStringExtra("password"));
//        edNote.setText(i.getStringExtra("note"));



        sunting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(profil.this, sunting_Activity.class);
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
}
