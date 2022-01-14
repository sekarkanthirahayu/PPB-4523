package com.example.appsambongrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private Button bt_register, bt_login;
    private EditText et_email, et_pass;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt_register = findViewById(R.id.bt_register);
        bt_login = findViewById(R.id.bt_login);
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);

        preferences = getSharedPreferences("UserInfo",0);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailValue = et_email.getText().toString();
                String passwordValue = et_pass.getText().toString();

                String registeredEmail = preferences.getString("email","");
                String registeredPassword = preferences.getString("password","");

                if(emailValue.equals(registeredEmail) && passwordValue.equals(registeredPassword)){
                    Intent intent = new Intent(login.this, menu.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(login.this, "Tidak valid! silakan coba lagi", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bt_register.setOnClickListener(view -> {
            Intent intent = new Intent(login.this, register.class);
            startActivity(intent);
        });
    }
}