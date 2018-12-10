package com.example.ulfa.itmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class profil extends AppCompatActivity {

    LinearLayout sunting , logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        sunting = (LinearLayout)findViewById(R.id.linier_Sunting);
        logout = (LinearLayout)findViewById(R.id.linier_keluar);

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
