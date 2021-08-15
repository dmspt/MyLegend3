package com.example.mylegend;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

;

public class ListeningSoal extends AppCompatActivity {

    TextView songStart, songAll;
    MediaPlayer mPlayer = null;
    ImageButton btn_play;
    AppCompatSeekBar songProgress;
    RadioGroup radiogroup;
    RadioButton pilihA, pilihB, pilihC, pilihD;
    int nomor = 0;
    public static int hasil, benar, salah;
    static int onTime = 0, startTime = 0, endTime = 0;
    Handler handler = new Handler();

    Integer[] pertanyaan = new Integer[]{
            R.raw.backsound,
            R.raw.chimez,
            R.raw.backsound,
            R.raw.chimez,
            R.raw.backsound,
            R.raw.chimez,
            R.raw.backsound,
            R.raw.chimez,
            R.raw.backsound,
            R.raw.chimez
    };

    String[] pertanyaann = new String[]{
            "Android.resource://" + this.getPackageName() + "/raw/backsound",
            "Android.resource://" + this.getPackageName() + "/raw/chimez",
            "Android.resource://" + this.getPackageName() + "/raw/backsound",
            "Android.resource://" + this.getPackageName() + "/raw/chimez",
            "Android.resource://" + this.getPackageName() + "/raw/backsound",
            "Android.resource://" + this.getPackageName() + "/raw/chimez",
            "Android.resource://" + this.getPackageName() + "/raw/backsound",
            "Android.resource://" + this.getPackageName() + "/raw/chimez",
            "Android.resource://" + this.getPackageName() + "/raw/backsound",
            "Android.resource://" + this.getPackageName() + "/raw/chimez"
    };

    String[] pilih_jawaban = new String[]{
            "does", "do", "are", "is",
            "studying", "study", "studies", "does",
            "does", "has", "are", "have",
            "is", "does", "do", "be",
            "do", "watching", "watches", "watch",
            "every day", "last day", "next week", "next time",
            "kill", "killes", "kills", "killed",
            "beat", "beats", "beating", "was beating",
            "give", "gives", "giving", "is giving",
            "do - laugh", "did - laugh", "are- laugh", "were - laughing"
    };

    String[] jawaban_benar = new String[]{
            "is",
            "studies",
            "have",
            "does",
            "watch",
            "every day",
            "kill",
            "was beating",
            "gives",
            "were - laugh"
    };

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_soal);

        //Diskripsi:
        btn_play = findViewById(R.id.btnPlay);
        songStart = findViewById(R.id.tv_song_current_duration);
        songAll = findViewById(R.id.tv_song_total_duration);
        songProgress = findViewById(R.id.seek_song_progressbar);

        mPlayer = new MediaPlayer();

        mPlayer = MediaPlayer.create(this, R.raw.backsound);

        /**
        endTime = mPlayer.getDuration();
        startTime = mPlayer.getCurrentPosition();
        if (onTime == 0) {
            songProgress.setMax(endTime);
            onTime = 1;
        }

        songAll.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes(endTime),
                TimeUnit.MILLISECONDS.toSeconds(endTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(endTime))));
        songStart.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes(startTime),
                TimeUnit.MILLISECONDS.toSeconds(startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(startTime))));
        songProgress.setProgress(startTime);
        handler.postDelayed(UpdateSongTime, 100);
*/
        btn_play.setOnClickListener(v -> {
            if (mPlayer!=null) {
                mPlayer.start();
                btn_play.setImageResource(R.drawable.ic_pause);

            } else {
                mPlayer.pause();
                btn_play.setImageResource(R.drawable.ic_play_arrow);

            }

        });

        radiogroup = findViewById(R.id.radioGroup);
        pilihA = findViewById(R.id.pilihA);
        pilihB = findViewById(R.id.pilihB);
        pilihC = findViewById(R.id.pilihC);
        pilihD = findViewById(R.id.pilihD);

        Typeface pilA = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        pilihA.setTypeface(pilA);
        Typeface pilB = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        pilihB.setTypeface(pilB);
        Typeface pilC = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        pilihC.setTypeface(pilC);
        Typeface pilD = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        pilihD.setTypeface(pilD);

        radiogroup.check(0);
        benar = 0;
        salah = 0;

        //Collections.shuffle(Arrays.asList(pertanyaan));

        try {
            mPlayer.setDataSource(pertanyaann[nomor]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pilihA.setText(pilih_jawaban[0]);
        pilihB.setText(pilih_jawaban[1]);
        pilihC.setText(pilih_jawaban[2]);
        pilihD.setText(pilih_jawaban[3]);

    }

    public void next(View view) throws IOException {
        if (pilihA.isChecked() || pilihB.isChecked() || pilihC.isChecked() || pilihD.isChecked()) {
            RadioButton jawaban_user = findViewById(radiogroup.getCheckedRadioButtonId());
            String ambil_jawaban = jawaban_user.getText().toString();
            radiogroup.check(0);
            if (ambil_jawaban.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan.length) {

                mPlayer.setDataSource(pertanyaann[nomor]);
                pilihA.setText(pilih_jawaban[(nomor*4)+0]);
                pilihB.setText(pilih_jawaban[(nomor*4)+1]);
                pilihC.setText(pilih_jawaban[(nomor*4)+2]);
                pilihD.setText(pilih_jawaban[(nomor*4)+3]);

            } else {
                hasil = benar * 10;
                finish();
                Intent selesai = new Intent(getApplicationContext(), SkorListening.class);
                startActivity(selesai);
            }
        }
        else
        {
            Toast.makeText(this, "Pilih Jawaban Terlebih Dahulu!", Toast.LENGTH_SHORT).show();
        }
    }

    private Runnable UpdateSongTime = new Runnable() {
        @SuppressLint("DefaultLocale")
        @Override
        public void run() {
            startTime = mPlayer.getCurrentPosition();
            songStart.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes(startTime),
                    TimeUnit.MILLISECONDS.toSeconds(startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(startTime))));
            songProgress.setProgress(startTime);
            handler.postDelayed(this, 100);
        }
    };

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Anda Belum Mengerjakan Evaluasi, Yakin Akan Keluar?")
                .setCancelable(false)
                .setPositiveButton("Ya", (dialog, id) -> finish())
                .setNegativeButton("Tidak", null)
                .show();
    }

}
