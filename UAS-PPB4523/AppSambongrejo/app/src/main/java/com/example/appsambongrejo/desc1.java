package com.example.appsambongrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class desc1 extends AppCompatActivity {
    private Button pesan1;
    private int price1, terimaUpdate=0, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc1);

        pesan1 = findViewById(R.id.pesan1);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdate2 = new AtomicInteger(terima.getIntExtra("update2",0));

        pesan1.setOnClickListener((view) ->{
            price1 = 5000;
            total = 1;
            terimaUpdate.addAndGet(total);
            terimaUpdate2.addAndGet(price1);
            Intent kirim = new Intent(desc1.this, menu.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("harga", terimaUpdate2.get());
            startActivity(kirim);

        });

    }
}