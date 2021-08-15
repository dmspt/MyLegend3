package com.example.mylegend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.chrisbanes.photoview.PhotoView;

import androidx.appcompat.app.AppCompatActivity;

public class Bantuan3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan3);

        Button bNext = findViewById(R.id.next);
        PhotoView photoView = findViewById(R.id.img);

        photoView.setImageResource(R.drawable.jawaban);

        bNext.setOnClickListener(v -> {
            finish();
            Intent in = new Intent(Bantuan3Activity.this, Bantuan4Activity.class);
            startActivity(in);
        });

    }

    public void close(View view) {
        super.onBackPressed();
    }

}
