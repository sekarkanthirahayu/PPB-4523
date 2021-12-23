package com.example.firebaseupdate;
import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class UpdateData extends AppCompatActivity {
    EditText nmmhs, nimmhs;
    Button saveEd, delete, viewlis;
    UpdateData FirebaseDatabase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_semua_data);

        FirebaseDatabase = new UpdateData ();
        nimmhs=(EditText) findViewById(R.id.nimmhs);
        nmmhs=(EditText) findViewById(R.id.nmmhs);
        saveEd=findViewById(R.id.tblsave);
        delete=findViewById(R.id.tbldelete);
        viewlis=findViewById(R.id.tblview);

        Bundle extras = getIntent().getExtras();

        nimmhs.setText(extras.getString("data1"));
        nmmhs.setText(extras.getString("data2"));

        saveEd=(Button)findViewById(R.id.tblsave);
        delete=(Button)findViewById(R.id.tbldelete);
        viewlis=(Button)findViewById(R.id.tblview);

        viewlis.setOnClickListener((v)->{
            Intent intent=new Intent(UpdateData.this,MainActivity.class);
            startActivity(intent);
        });

        saveEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nimmhs.setText(nmmhs.getText().toString());

                boolean UpdateData=(nimmhs.getText().toString(),nmmhs.getText().toString());
                if (UpdateData==true){
                    Toast.makeText(UpdateData.this, "Update Success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UpdateData.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
