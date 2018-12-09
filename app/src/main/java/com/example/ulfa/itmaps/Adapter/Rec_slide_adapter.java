package com.example.ulfa.itmaps.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ulfa.itmaps.Models.RuanganModel;
import com.example.ulfa.itmaps.R;
import com.example.ulfa.itmaps.Rest.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class Rec_slide_adapter extends RecyclerView.Adapter<Rec_slide_adapter.SlideViewHolder> {
    List<RuanganModel> listRuanganImage;
    public Rec_slide_adapter(List<RuanganModel>listRuanganImage){this.listRuanganImage = listRuanganImage;}

    @Override
    public Rec_slide_adapter.SlideViewHolder onCreateViewHolder( ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_image, parent, false);
        SlideViewHolder mHolder = new SlideViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(Rec_slide_adapter.SlideViewHolder slideViewHolder, final int position) {
        slideViewHolder.id_r.setText(listRuanganImage.get(position).getKd_ruangan());
        if (listRuanganImage.get(position).getPhoto_ruangan().length()>0){
            //Picasso.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+listPembeli.get(position).getPhotoId()).into(holder.mPhotoid);
            Glide.with(slideViewHolder.itemView.getContext()).load(ApiClient.BASE_IMAGE_RUANGAN+listRuanganImage.get(position).getPhoto_ruangan()).into(slideViewHolder.photo_ruangan);
        }else{
            //Picasso.with(holder.itemView.getContext()).load(R.drawable.photoid).into(holder.mPhotoid);
            Glide.with(slideViewHolder.itemView.getContext()).load(R.mipmap.ic_launcher).into(slideViewHolder.photo_ruangan);
        }
    }

    @Override
    public int getItemCount() {
        return listRuanganImage.size();
    }

    public class SlideViewHolder extends RecyclerView.ViewHolder{
        ImageView photo_ruangan;
        TextView id_r;
        public SlideViewHolder(View itemView){
            super(itemView);
            photo_ruangan = itemView.findViewById(R.id.img_slide);
            id_r = itemView.findViewById(R.id.txt_slide);
        }
    }
}
