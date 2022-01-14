package com.example.appsambongrejo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appsambongrejo.databinding.ActivityMenuBinding;

public class menu extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMenuBinding binding;
    private CardView cd1, cd2, cd3, cd4, cd5, cd6;
    private TextView total;
    private TextView harga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cd1 = findViewById(R.id.cd1);
        cd2 = findViewById(R.id.cd2);
        cd3 = findViewById(R.id.cd3);
        cd4 = findViewById(R.id.cd4);
        cd5 = findViewById(R.id.cd5);
        cd6 = findViewById(R.id.cd6);
        total = findViewById(R.id.total);
        harga = findViewById(R.id.harga);

        Intent terima = getIntent();
        int terimaTotal = terima.getIntExtra("total", 0);
        int terimaHarga = terima.getIntExtra("harga",0);


        total.setText("Total : "+Integer.toString(terimaTotal));
        harga.setText("Harga : "+"Rp"+Integer.toString(terimaHarga)+",00");


        cd1.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            Intent update = new Intent(menu.this, desc1.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            startActivity(update);
        });

        cd2.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            Intent update = new Intent(menu.this, desc2.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            startActivity(update);
        });

        cd3.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            Intent update = new Intent(menu.this, desc3.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            startActivity(update);
        });

        cd4.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            Intent update = new Intent(menu.this, desc4.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            startActivity(update);
        });

        cd5.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            Intent update = new Intent(menu.this, desc5.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            startActivity(update);
        });

        cd6.setOnClickListener(view -> {
            int updateTotal = terima.getIntExtra("total",0);
            int updateHarga = terima.getIntExtra("harga",0);
            Intent update = new Intent(menu.this, desc6.class);
            update.putExtra("update", updateTotal);
            update.putExtra("update2",updateHarga);
            startActivity(update);
        });

        harga.setOnClickListener(view -> {
            String totalform = total.getText().toString();
            String hargaform = harga.getText().toString();

            Intent kirim = new Intent(menu.this, form.class);
            kirim.putExtra("total", totalform);
            kirim.putExtra("harga",hargaform);
            startActivity(kirim);
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMap();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayMap() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        // Using the coordinates for Google headquarters.
        String data = getString(R.string.google_mtv_coord_zoom12);
        intent.setData(Uri.parse(data));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}