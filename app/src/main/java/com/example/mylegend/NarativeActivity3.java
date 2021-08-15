package com.example.mylegend;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NarativeActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narative3);

        ImageButton btn_close = findViewById(R.id.btnClose);
        ImageButton btn_back = findViewById(R.id.btnBack);
        TextView txt = findViewById(R.id.txtNaras);
        TextView txt2 = findViewById(R.id.txtNaras2);

        Typeface q = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt.setTypeface(q);

        Typeface q2 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt2.setTypeface(q2);

        btn_close.setOnClickListener(view -> finish());

        btn_back.setOnClickListener(view -> {
            finish();
            Intent i = new Intent(NarativeActivity3.this, NarativeActivity2.class);
            startActivity(i);
        });

    }
}