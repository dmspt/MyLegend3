package com.example.mylegend;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NarativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narative);

        ImageButton btn_close = findViewById(R.id.btnClose);
        ImageButton btn_next = findViewById(R.id.btnNext);
        TextView txt = findViewById(R.id.txtNar);
        TextView txt2 = findViewById(R.id.txtNar2);
        TextView txt3 = findViewById(R.id.txtNar3);
        TextView txt4 = findViewById(R.id.txtNar4);
        TextView txt5 = findViewById(R.id.txtNar5);
        TextView txt6 = findViewById(R.id.txtNar6);
        TextView txt7 = findViewById(R.id.txtNar7);
        TextView txt8 = findViewById(R.id.txtNar8);
        TextView txt9 = findViewById(R.id.txtNar9);
        TextView txt10 = findViewById(R.id.txtNar10);

        Typeface q = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt.setTypeface(q);

        Typeface q2 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt2.setTypeface(q2);

        Typeface q3 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt3.setTypeface(q3);

        Typeface q4 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt4.setTypeface(q4);

        Typeface q5 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt5.setTypeface(q5);

        Typeface q6 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt6.setTypeface(q6);

        Typeface q7 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt7.setTypeface(q7);

        Typeface q8 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt8.setTypeface(q8);

        Typeface q9 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt9.setTypeface(q9);

        Typeface q10 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt10.setTypeface(q10);

        btn_close.setOnClickListener(view -> finish());

        btn_next.setOnClickListener(view -> {
            finish();
            Intent i = new Intent(NarativeActivity.this, NarativeActivity2.class);
            startActivity(i);
        });

    }
}