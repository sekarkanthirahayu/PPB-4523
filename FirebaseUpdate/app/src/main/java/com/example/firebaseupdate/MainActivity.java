package com.example.firebaseupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText nimmahasiswa,namamahasiswa;
    Button btnsave,btnview;
    DatabaseReference reference;
    Mahasiswa mahasiswa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nimmahasiswa=findViewById(R.id.nimmhs);
        namamahasiswa=findViewById(R.id.nmmhs);
        btnsave=findViewById(R.id.tblsave);
        btnview=findViewById(R.id.tblview);
        mahasiswa=new Mahasiswa();

        reference= FirebaseDatabase.getInstance().getReference().child("Mahasiswa");

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswa.setNim(nimmahasiswa.getText().toString().trim());
                mahasiswa.setNama(namamahasiswa.getText().toString().trim());
                reference.push().setValue(mahasiswa);
                Toast.makeText(MainActivity.this,"Data Tersimpan",Toast.LENGTH_LONG).show();
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TampilSemuaData.class);
                startActivity(intent);
            }
        });
    }
}
