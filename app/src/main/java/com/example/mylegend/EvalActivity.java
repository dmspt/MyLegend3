package com.example.mylegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class EvalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eval);

        ImageButton btn_close = findViewById(R.id.btnClose);
        ImageButton btn_eval = findViewById(R.id.btnEval);
        ImageButton btn_listen = findViewById(R.id.btnListen);

        btn_close.setOnClickListener(view -> finish());

        btn_eval.setOnClickListener(view -> {
            Intent i = new Intent(EvalActivity.this, kuis_intruksi.class);
            startActivity(i);
        });

        btn_listen.setOnClickListener(view -> {
            Intent i = new Intent(EvalActivity.this, ListeningInstruksi.class);
            startActivity(i);
        });

    }
}