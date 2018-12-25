package com.example.ulfa.itmaps;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.miguelcatalan.materialsearchview.MaterialSearchView;


public class Pencarian_Activity extends AppCompatActivity {
    private MaterialSearchView mMaterialSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian_);

        Toolbar toolbar = findViewById(R.id.pencariantoolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("ffffff"));

        mMaterialSearch =findViewById(R.id.pencarianView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_chat,menu);
        MenuItem menuItem = menu.findItem(R.id.cariMenu);
        mMaterialSearch.setMenuItem(menuItem);
        return super.onCreateOptionsMenu(menu);
    }

}
