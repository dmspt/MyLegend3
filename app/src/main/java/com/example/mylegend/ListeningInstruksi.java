package com.example.mylegend;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListeningInstruksi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeninginstruksi);

        TextView txt = findViewById(R.id.txt);
        TextView txt2= findViewById(R.id.txt2);

        Typeface text = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt.setTypeface(text);

        Typeface text2 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt2.setTypeface(text2);

    }

    public void next(View view) {
        finish();
        Intent intent = new Intent(ListeningInstruksi.this, ListeningSoal.class);
        startActivity(intent);
    }

    public void close(View view) {
        finish();
    }
}
