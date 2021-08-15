package com.example.mylegend;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn_materi = findViewById(R.id.btnMateri);
        ImageButton btn_kompetensi = findViewById(R.id.btnKompetensi);
        ImageButton btn_eval = findViewById(R.id.btnEvaluasi);
        ImageButton btn_game = findViewById(R.id.btnGame);
        ImageButton btn_info = findViewById(R.id.btnInfo);
        ImageButton btn_sound = findViewById(R.id.btnSound);

        mp = MediaPlayer.create(this, R.raw.chimez);
        mp.setLooping(true);
        mp.setVolume(1, 1);
        mp.start();

        btn_materi.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, MateriActivity.class);
            startActivity(i);
        });

        btn_kompetensi.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, KompetensiActivity.class);
            startActivity(i);
        });

        btn_eval.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, kuis_intruksi.class);
            startActivity(i);
        });

        btn_game.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, GameActivity.class);
            startActivity(i);
        });

        btn_info.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(i);
            //getSupportFragmentManager().beginTransaction().add(R.id.fragmentinfo, new Info()).addToBackStack(null).commit();
        });

        btn_sound.setOnClickListener(view -> {
            if (mp.isPlaying()) {
                mp.pause();
                btn_sound.setBackgroundResource(R.drawable.icbtnsound);
            } else {
                mp.start();
                btn_sound.setBackgroundResource(R.drawable.icbtnsoundoff);
            }

        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apa Anda ingin keluar dari aplikasi ini?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                        mp.stop();
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }

}