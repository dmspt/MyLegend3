package com.example.mylegend;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SimplepastActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplepast2);

        ImageButton btn_close = findViewById(R.id.btnClose);
        ImageButton btn_back = findViewById(R.id.btnBack);
        TextView txt = findViewById(R.id.txtSimp);
        TextView txt2 = findViewById(R.id.txtSimp2);
        TextView txt3 = findViewById(R.id.txtSimp3);
        TextView txt4 = findViewById(R.id.txtSimp4);

        Typeface q = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt.setTypeface(q);

        Typeface q2 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt2.setTypeface(q2);

        Typeface q3 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt3.setTypeface(q3);

        Typeface q4 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt4.setTypeface(q4);

        btn_close.setOnClickListener(view -> finish());

        btn_back.setOnClickListener(view -> {
            finish();
            Intent i = new Intent(SimplepastActivity2.this, SimplepastActivity.class);
            startActivity(i);
        });

    }
}