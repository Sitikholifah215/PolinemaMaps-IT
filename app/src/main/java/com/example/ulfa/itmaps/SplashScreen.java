package com.example.ulfa.itmaps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(SplashScreen.this, MainActivity_login.class);
                startActivity(login);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
