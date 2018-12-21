package com.example.ulfa.itmaps.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ulfa.itmaps.Models.Item;
import com.example.ulfa.itmaps.R;

import java.util.ArrayList;
import java.util.List;

public class Menu_adapter extends RecyclerView.Adapter<Menu_adapter.MyHolder> {

    private List<Item> menuList;
    private Context context;
    public Menu_adapter(List<Item> menuList, Context context){
        this.menuList = menuList;
        this.context = context;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_cio, parent, false);
        return new MyHolder(layout);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tv_name.setText(menuList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Kamu memilih " + menuList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public int getItemCount() {
        return menuList.size();
        //return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.judul_menu);
        }
    }
    public void setFilter (List<Item> itemList){
        menuList = new ArrayList<>();
        menuList.addAll(itemList);
        notifyDataSetChanged();
    }
}
