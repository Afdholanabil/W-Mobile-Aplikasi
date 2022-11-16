package com.example.recyclickprojek.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclickprojek.Model.ModelDataBarang;
import com.example.recyclickprojek.R;

import java.util.List;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.HolderData> {
    private Context cntx;
    private List<ModelDataBarang> listbarang;

    public AdapterBarang(Context cntx, List<ModelDataBarang> listbarang) {
        this.cntx = cntx;
        this.listbarang = listbarang;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.receycleview_barang, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        ModelDataBarang mdb = listbarang.get(position);

        holder.id.setText(mdb.getId());
        holder.jdl.setText(mdb.getNama());
        holder.hrg.setText(String.valueOf(mdb.getHarga()));
        holder.desk.setText(mdb.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return listbarang.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView id, jdl, hrg, desk;


        public HolderData(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.txt_id);
            jdl = itemView.findViewById(R.id.txt_judul2);
            hrg = itemView.findViewById(R.id.txt_harga2);
            desk = itemView.findViewById(R.id.txt_des2);
        }
    }
}
