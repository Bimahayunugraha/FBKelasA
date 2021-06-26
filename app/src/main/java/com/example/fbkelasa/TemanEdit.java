package com.example.fbkelasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fbkelasa.database.Teman;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TemanEdit extends AppCompatActivity {

    TextView tvKey;
    EditText edNama, edTelpon;
    Button btnEdit;
    DatabaseReference databaseReference;
    String kode, nama, telpon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_edit);

        tvKey = findViewById(R.id.tvKey);
        edNama = findViewById(R.id.edNama);
        edTelpon = findViewById(R.id.edTelpon);
        btnEdit = findViewById(R.id.btnEdit);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        Bundle bundle = this.getIntent().getExtras();
        kode = bundle.getString("Kunci1");
        nama = bundle.getString("Kunci2");
        telpon = bundle.getString("Kunci3");

        tvKey.setText(kode);
        edNama.setText(nama);
        edTelpon.setText(telpon);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTeman(new Teman(edNama.getText().toString(), edTelpon.getText().toString()));
            }
        });
    }

    public void editTeman(Teman teman) {
        databaseReference.child("Teman") //Akses parent index, ibaratnya seperti nama tabel
                .child(kode) //Select teman berdasarkan key
                .setValue(teman) //Set value teman yang baru
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(TemanEdit.this, "Data Berhasil Diupdate", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
    }
}