package com.example.appsambongrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class desc6 extends AppCompatActivity {
    private Button pesan6;
    private int price6, terimaUpdate=0, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc6);

        pesan6 = findViewById(R.id.pesan6);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdate2 = new AtomicInteger(terima.getIntExtra("update2",0));
        pesan6.setOnClickListener((view) ->{
            price6 = 14000;
            total = 1;
            terimaUpdate.addAndGet(total);
            terimaUpdate2.addAndGet(price6);
            Intent kirim = new Intent(desc6.this, menu.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("harga", terimaUpdate2.get());
            startActivity(kirim);

        });
    }
}