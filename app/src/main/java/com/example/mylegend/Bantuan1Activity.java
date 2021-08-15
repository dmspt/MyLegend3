package com.example.mylegend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.chrisbanes.photoview.PhotoView;

import androidx.appcompat.app.AppCompatActivity;

public class Bantuan1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan1);

        Button bNext = findViewById(R.id.next);
        PhotoView photoView = findViewById(R.id.img);

        photoView.setImageResource(R.drawable.piliihanpuzzle);

        bNext.setOnClickListener(v -> {
            finish();
            Intent in = new Intent(Bantuan1Activity.this, Bantuan2Activity.class);
            startActivity(in);
        });

    }

    public void close(View view) {
        super.onBackPressed();
    }

}
