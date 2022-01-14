package com.example.appsambongrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class desc3 extends AppCompatActivity {
    private Button pesan3;
    private int price3, terimaUpdate=0, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc3);

        pesan3 = findViewById(R.id.pesan3);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdate2 = new AtomicInteger(terima.getIntExtra("update2",0));
        pesan3.setOnClickListener((view) ->{
            price3 = 20000;
            total = 1;
            terimaUpdate.addAndGet(total);
            terimaUpdate2.addAndGet(price3);
            Intent kirim = new Intent(desc3.this, menu.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("harga", terimaUpdate2.get());
            startActivity(kirim);

        });
    }
}