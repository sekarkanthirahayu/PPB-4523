package com.example.appsambongrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class form extends AppCompatActivity {
    private TextView total;
    private TextView harga;
    private Button setuju;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        total = findViewById(R.id.total);
        harga = findViewById(R.id.harga);
        setuju = findViewById(R.id.setuju);

        Intent terima = getIntent();
        String terimaTotal = terima.getStringExtra("total");
        String terimaHarga = terima.getStringExtra("harga");
        total.setText(terimaTotal);
        harga.setText(terimaHarga);

        setuju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(form.this, "Disetujui", Toast.LENGTH_SHORT).show();
            }
        });



    }
}