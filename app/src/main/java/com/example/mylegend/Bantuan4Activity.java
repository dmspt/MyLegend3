package com.example.mylegend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.chrisbanes.photoview.PhotoView;

import androidx.appcompat.app.AppCompatActivity;

public class Bantuan4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan44);

        Button bBack = findViewById(R.id.back);
        PhotoView photoView = findViewById(R.id.img);

        photoView.setImageResource(R.drawable.skor);

        bBack.setOnClickListener(v -> {
            finish();
            Intent in = new Intent(Bantuan4Activity.this, Bantuan3Activity.class);
            startActivity(in);
        });

    }

    public void close(View view) {
        super.onBackPressed();
    }

}
