package com.example.ulfa.itmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class sunting_Activity extends AppCompatActivity {

    TextView EdNim, EdNama;
    EditText EdPaass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunting_);
        EdNim =(TextView)findViewById(R.id.nim_profil);
        EdNama = (TextView)findViewById(R.id.nama_profil);
        EdPaass =(EditText)findViewById(R.id.password_profil);

        Intent i = getIntent();
        String namaUser = i.getStringExtra("nama_user");
        String usernameNim = i.getStringExtra("username");
        String passwordNim = i.getStringExtra("password");
        EdNama.setText(i.getStringExtra("nama_user"));
        EdNim.setText(usernameNim);
        EdPaass.setText(passwordNim);

    }
}
