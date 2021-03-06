package com.example.ulfa.itmaps;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;
    RelativeLayout animLayout;
    AnimationDrawable animdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //animasi
        animLayout = (RelativeLayout) findViewById(R.id.animLayout);
        animdraw = (AnimationDrawable) animLayout.getBackground();
        animdraw.setEnterFadeDuration(4500);
        animdraw.setExitFadeDuration(4500);
        animdraw.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent login = new Intent(MainActivity.this, MainActivity_login.class);
                startActivity(login);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
