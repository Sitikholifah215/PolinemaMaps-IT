package com.example.ulfa.itmaps.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ulfa.itmaps.Models.RuanganModel;
import com.example.ulfa.itmaps.R;

import java.util.List;

public class ChatRuanganAdapter extends RecyclerView.Adapter<ChatRuanganAdapter.CariRuangViewHolder>{

    List<RuanganModel> listRuangan;

    public ChatRuanganAdapter(List<RuanganModel> listRuangan) {
        this.listRuangan = listRuangan;
    }

    @NonNull
    @Override
    public ChatRuanganAdapter.CariRuangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int position) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_massage, parent, false);
        CariRuangViewHolder mHolder = new CariRuangViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatRuanganAdapter.CariRuangViewHolder cariRuangViewHolder, final int position) {

        cariRuangViewHolder.txt_nm_ruangan.setText(listRuangan.get(position).getNm_ruangan());
    }

    @Override
    public int getItemCount() {
        return listRuangan.size();
    }

    public class CariRuangViewHolder extends RecyclerView.ViewHolder {

        TextView txt_nm_ruangan;

        public CariRuangViewHolder(View itemView) {
            super(itemView);

            txt_nm_ruangan = itemView.findViewById(R.id.textContentUser);
        }
    }

}
