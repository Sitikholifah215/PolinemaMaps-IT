package com.example.ulfa.itmaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity_Home extends AppCompatActivity {
    private RecyclerView.LayoutManager laymanager;
    private RecyclerView.Adapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__home);


    }
    private void  initRecyclerview_SlideImage(){

        laymanager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerViewww = findViewById(R.id.RecyclerviewhorizontalSlide);
        recyclerViewww.setLayoutManager(laymanager);

//            madapter = new Rec_slide_adapter(mImagesUrl,this);
//            recyclerViewww.setAdapter(madapter);

    }
}
