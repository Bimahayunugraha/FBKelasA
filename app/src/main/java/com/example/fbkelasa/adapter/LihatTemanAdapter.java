package com.example.fbkelasa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fbkelasa.R;
import com.example.fbkelasa.database.Teman;

import java.util.ArrayList;

public class LihatTemanAdapter extends RecyclerView.Adapter<LihatTemanAdapter.ViewHolder> {

    private ArrayList<Teman> daftarTeman;
    private Context context;

    public LihatTemanAdapter(ArrayList<Teman> daftarTeman, Context context) {
        this.daftarTeman = daftarTeman;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teman, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LihatTemanAdapter.ViewHolder holder, int position) {
        String nama = daftarTeman.get(position).getNama();
        holder.tvNama.setText(nama);

    }

    @Override
    public int getItemCount() {
        return daftarTeman.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNama;

        ViewHolder(View v) {
            super(v);
            tvNama = (TextView) v.findViewById(R.id.tvNama);
        }
    }
}
