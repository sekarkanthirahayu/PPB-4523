package com.example.appsambongrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicInteger;

public class desc2 extends AppCompatActivity {
    private Button pesan2;
    private int price2, terimaUpdate=0, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc2);

        pesan2 = findViewById(R.id.pesan2);

        Intent terima = getIntent();
        AtomicInteger terimaUpdate = new AtomicInteger(terima.getIntExtra("update", 0));
        AtomicInteger terimaUpdate2 = new AtomicInteger(terima.getIntExtra("update2",0));
        pesan2.setOnClickListener((view) ->{
            price2 = 18000;
            total = 1;
            terimaUpdate.addAndGet(total);
            terimaUpdate2.addAndGet(price2);
            Intent kirim = new Intent(desc2.this, menu.class);
            kirim.putExtra("total", terimaUpdate.get());
            kirim.putExtra("harga", terimaUpdate2.get());
            startActivity(kirim);

        });
    }
}