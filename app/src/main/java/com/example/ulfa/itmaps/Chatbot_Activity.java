package com.example.ulfa.itmaps;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ulfa.itmaps.Adapter.Menu_adapter;
import com.example.ulfa.itmaps.Models.Item;

import java.util.ArrayList;
import java.util.List;

public class Chatbot_Activity extends AppCompatActivity {

    android.support.v7.widget.SearchView searchView;
    RecyclerView recyclerView;
    Menu_adapter adapter;
    List<Item> menuList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot_);

        recyclerView = (RecyclerView)findViewById(R.id.listShow);
        searchView = (SearchView)findViewById(R.id.search_src_text) ;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSeacrh);
        setSupportActionBar(toolbar);

        //DATA MENU DAN GAMBAR MENU
        menuList.add(new Item("Cumi Saus Padang"));
        menuList.add(new Item("Iga Bakar Rica"));
        menuList.add(new Item("Lodeh"));
        menuList.add(new Item("Opor Ayam"));
        menuList.add(new Item("Pepes Jamur Tiram"));
        menuList.add(new Item("Pepes Telor Asin"));
        menuList.add(new Item("Pindang Krecek Ikan Kembung"));
        menuList.add(new Item("Rica-rica Ceker"));
        menuList.add(new Item("Sambel Rebus Ikan Tongkol"));
        menuList.add(new Item("Sambel Bawang Ulek"));
        menuList.add(new Item("Sambel Goreng Teri"));
        menuList.add(new Item("Sambel Rindang Teri"));
        menuList.add(new Item("Sayur Asem"));
        menuList.add(new Item("Telor Dadar Sawi"));
        recyclerView = findViewById(R.id.listShow);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Menu_adapter(menuList, Chatbot_Activity.this);
        recyclerView.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_chat, menu);
        final MenuItem myActionMenu = menu.findItem(R.id.cari);
        searchView = (android.support.v7.widget.SearchView)myActionMenu.getActionView();
        changeSearchViewTextColor(searchView);
        ((EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.colorYellaw));
        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()){
                    searchView.setIconified(true);
                }
                myActionMenu.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Item> filtermodelist = filter (menuList, newText);
                adapter.setFilter(filtermodelist);
                return true;
            }
        });
        return true;
    }
    private List<Item> filter(List<Item> pl, String query) {
        query = query.toLowerCase();
        final List<Item>filteredModelList = new ArrayList<>();
        for (Item model:pl){
            final String text = model.getName().toLowerCase();
            if (text.contains(query)){
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
    private void changeSearchViewTextColor(SearchView view) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeSearchViewTextColor((SearchView) viewGroup.getChildAt(i));
                }
            }
        }
    }
