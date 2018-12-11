package com.example.ulfa.itmaps.Adapter;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ulfa.itmaps.Models.GedungModel;
import com.example.ulfa.itmaps.R;
import com.example.ulfa.itmaps.Rest.ApiClient;

import java.util.List;

public class GedungViewAdapter extends RecyclerView.Adapter<GedungViewAdapter.GedungViewHolder> {
    List<GedungModel> listgedung;
    public GedungViewAdapter(List<GedungModel>listgedung){this.listgedung = listgedung;}

    @Override
    public GedungViewHolder onCreateViewHolder(ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_gedung, parent, false);
        GedungViewHolder mHolder = new GedungViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(GedungViewAdapter.GedungViewHolder gedungViewHolder, final int position) {
        gedungViewHolder.kd_gedung.setText(listgedung.get(position).getKd_gedung());
        gedungViewHolder.nm_gedung.setText(listgedung.get(position).getNm_gedung());
        if (listgedung.get(position).getPhoto_gedung().length()>0){
            //Picasso.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+listPembeli.get(position).getPhotoId()).into(holder.mPhotoid);
            Glide.with(gedungViewHolder.itemView.getContext()).load(ApiClient.BASE_IMAGE_RUANGAN+listgedung.get(position).getPhoto_gedung()).into(gedungViewHolder.img_gedung_list);
        }else {
            //Picasso.with(holder.itemView.getContext()).load(R.drawable.photoid).into(holder.mPhotoid);
            Glide.with(gedungViewHolder.itemView.getContext()).load(R.mipmap.ic_launcher).into(gedungViewHolder.img_gedung_list);
        }
    }

    @Override
    public int getItemCount() {
        return listgedung.size();
    }

    public class GedungViewHolder extends RecyclerView.ViewHolder{
        ImageView img_gedung_list;
        TextView kd_gedung, nm_gedung;
        public GedungViewHolder(View itemView){
            super(itemView);
            img_gedung_list = itemView.findViewById(R.id.img_list_gedung);
            kd_gedung = itemView.findViewById(R.id.txt_kd_gedung);
            nm_gedung = itemView.findViewById(R.id.txt_nm_gedung);
        }
    }


}
