package com.example.appsambongrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class desc5 extends AppCompatActivity {
    private Button pesan5;
    private int price5, terimaUpdate=0, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc5);

        pesan5 = findViewById(R.id.pesan5);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdate2 = new AtomicInteger(terima.getIntExtra("update2",0));
        pesan5.setOnClickListener((view) ->{
            price5 = 8000;
            total = 1;
            terimaUpdate.addAndGet(total);
            terimaUpdate2.addAndGet(price5);
            Intent kirim = new Intent(desc5.this, menu.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("harga", terimaUpdate2.get());
            startActivity(kirim);

        });
    }
}