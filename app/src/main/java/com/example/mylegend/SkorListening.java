package com.example.mylegend;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SkorListening extends AppCompatActivity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_kuis);

        //Kamus + Deskripsi:
        TextView hasil = findViewById(R.id.hasil);
        TextView nilai = findViewById(R.id.nilai);
        ImageView gambar = findViewById(R.id.img);

        hasil.setText("Jawaban Benar\t: " + kuis_soal.benar + "\nJawaban Salah\t  : " + kuis_soal.salah);
        if (kuis_soal.hasil>=70){
            gambar.setImageResource(R.drawable.jempol);
            nilai.setTextColor(getColor(R.color.strokeGreen));
            nilai.setText("" + kuis_soal.hasil);
        } else {
            gambar.setImageResource(R.drawable.sad);
            nilai.setTextColor(getColor(R.color.design_default_color_error));
            nilai.setText("" + kuis_soal.hasil);
        }

        Typeface proses3 = Typeface.createFromAsset(getAssets(), "font/Bubble_Bobble.ttf");
        hasil.setTypeface(proses3);

        Typeface sumber = Typeface.createFromAsset(getAssets(), "font/Bubble_Bobble.ttf");
        nilai.setTypeface(sumber);
    }

    public void ulangi(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), kuis_soal.class);
        startActivity(intent);
    }

    public void close(View view) {
        finish();
    }

}
