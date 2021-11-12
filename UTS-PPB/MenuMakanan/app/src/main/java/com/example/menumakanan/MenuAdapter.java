package com.example.menumakanan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    public MenuAdapter(ArrayList<MenuMakanan> listMenu) {
        this.listMenu = listMenu;
    }

    private ArrayList<MenuMakanan> listMenu;

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.menu_layout, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        MenuMakanan MenuMakanan = listMenu.get(position);
        holder.textNama.setText(MenuMakanan.getNama());
        holder.textHarga.setText(MenuMakanan.getHarga());
        holder.imageFoto.setImageResource(MenuMakanan.getimageFoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),MenuMakanan.getDeskripsi(), Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textNama, textHarga;
        public ImageView imageFoto;
        public ConstraintLayout itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textNama = (TextView) itemView.findViewById(R.id.textNama);
            textHarga = (TextView) itemView.findViewById(R.id.textHarga);
            imageFoto = (ImageView) itemView.findViewById(R.id.imageFoto);
        }
    }
}

