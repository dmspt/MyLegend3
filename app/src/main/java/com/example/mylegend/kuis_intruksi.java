package com.example.mylegend;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class kuis_intruksi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_intruksi);

        TextView txt = findViewById(R.id.txt);
        TextView txt2= findViewById(R.id.txt2);
        FloatingActionButton fab = findViewById(R.id.helpButton);

        Typeface text = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt.setTypeface(text);

        Typeface text2 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt2.setTypeface(text2);

        fab.setOnClickListener(view -> {
            Intent i = new Intent(kuis_intruksi.this, Bantuan3Activity.class);
            startActivity(i);
        });

    }

    public void next(View view) {
        finish();
        Intent intent = new Intent(kuis_intruksi.this, kuis_soal.class);
        startActivity(intent);
    }

    public void close(View view) {
        finish();
    }
}
