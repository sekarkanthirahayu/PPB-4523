package com.example.menumakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recylerMenu;
    private ArrayList<MenuMakanan> listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recylerMenu = findViewById(R.id.recylerMenu);
        initData();

        recylerMenu.setAdapter((new MenuAdapter(listMenu)));
        recylerMenu.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        this.listMenu = new ArrayList<>();
        listMenu.add(new MenuMakanan("Ramen", "Rp 22.000", "Ramen adalah masakan mi kuah yang ditambah nori, bawang goreng, irisan daun bawang, daging, telur rebus, dan berbagai tambahan lainnya sebagai lauk", R.drawable.ramen));

        listMenu.add(new MenuMakanan("Toast", "20.000", "Toast adalah roti bakar yang ditambah daging, sayur,saor, mayonaise, serta telur", R.drawable.toast));

        listMenu.add(new MenuMakanan("Nasi Goreng", "17.000", "Nasi goreng dengan tambahan sayuran, krupk serta ayam atau daging", R.drawable.nasigoreng));

        listMenu.add(new MenuMakanan("Ricebowl", "20.000", "Rice bowl biasanya terdiri dari nasi putih hangat dengan berbagai macam lauk di atasnya, seperti ikan, daging, dan sayur-sayuran", R.drawable.ricebowl));

        listMenu.add(new MenuMakanan("Takoyaki", "15.000", "Takoyaki adalah makanan yang berbentuk bulat yang didalamnya terdapat berbagai topping", R.drawable.takoyaki));

        listMenu.add(new MenuMakanan("Ice Cream", "15.000", "Takoyaki adalah makanan yang berbentuk bulat yang didalamnya terdapat berbagai topping", R.drawable.icecream));

    }
}

