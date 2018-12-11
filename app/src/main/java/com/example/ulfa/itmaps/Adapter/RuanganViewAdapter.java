package com.example.ulfa.itmaps.Adapter;

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

import java.util.List;

public class RuanganViewAdapter extends RecyclerView.Adapter<RuanganViewAdapter.RuanganViewHolder> {
    List<RuanganModel> listRuangan;
    public RuanganViewAdapter(List<RuanganModel>listRuangan){this.listRuangan = listRuangan;}

    @Override
    public RuanganViewAdapter.RuanganViewHolder onCreateViewHolder(ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ruangan, parent, false);
        RuanganViewHolder mHolder = new RuanganViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(RuanganViewAdapter.RuanganViewHolder ruanganViewHolder, final int position) {
        ruanganViewHolder.txt_kd_ruangan.setText(listRuangan.get(position).getKd_ruangan());
        ruanganViewHolder.txt_nm_ruangan.setText(listRuangan.get(position).getNm_ruangan());
        if (listRuangan.get(position).getPhoto_ruangan().length()>0){
            //Picasso.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+listPembeli.get(position).getPhotoId()).into(holder.mPhotoid);
            Glide.with(ruanganViewHolder.itemView.getContext()).load(ApiClient.BASE_IMAGE_RUANGAN+listRuangan.get(position).getPhoto_ruangan()).into(ruanganViewHolder.img_ruangan);
        }else{
            //Picasso.with(holder.itemView.getContext()).load(R.drawable.photoid).into(holder.mPhotoid);
            Glide.with(ruanganViewHolder.itemView.getContext()).load(R.mipmap.ic_launcher).into(ruanganViewHolder.img_ruangan);
        }
    }

    @Override
    public int getItemCount() {
        return listRuangan.size();
    }

    public class RuanganViewHolder extends RecyclerView.ViewHolder {
        ImageView img_ruangan;
        TextView txt_kd_ruangan, txt_nm_ruangan;
        public RuanganViewHolder(View itemView) {
            super(itemView);
            img_ruangan = itemView.findViewById(R.id.img_list_ruangan);
            txt_kd_ruangan = itemView.findViewById(R.id.txt_kd_r);
            txt_nm_ruangan = itemView.findViewById(R.id.txt_nm_r);
        }
    }
}
