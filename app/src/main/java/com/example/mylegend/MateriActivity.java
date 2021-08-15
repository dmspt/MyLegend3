package com.example.mylegend;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MateriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        ImageButton btn_close = findViewById(R.id.btnClose);
        ImageButton btn_simple = findViewById(R.id.btnSimple);
        ImageButton btn_narative = findViewById(R.id.btnNarative);

        btn_close.setOnClickListener(view -> finish());

        btn_simple.setOnClickListener(view -> {
            Intent i = new Intent(MateriActivity.this, SimplepastActivity.class);
            startActivity(i);
        });

        btn_narative.setOnClickListener(view -> {
            Intent i = new Intent(MateriActivity.this, NarativeActivity.class);
            startActivity(i);
        });

    }
}