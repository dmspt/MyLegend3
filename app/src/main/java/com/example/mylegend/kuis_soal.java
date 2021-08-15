package com.example.mylegend;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

;

public class kuis_soal extends AppCompatActivity {

    TextView quis;
    RadioGroup radiogroup;
    RadioButton pilihA, pilihB, pilihC, pilihD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] pertanyaan = new String[]{
            "Gina cooks fried rice. It … amazing.",
            "She is a student. She … at school.",
            "They … a test every week.",
            "She … not work because she has flu.",
            "We … soccer match.",
            "My brother rides a bike to school …",
            "Most animals … only for food.",
            "I ran so fast that my heart . . . really hard.",
            "The teacher always . . . us interesting project work.",
            "Why. . . you all . . . when he came in?",
            "Who was Dayang Sumbi? she was …",
            "“He met a beautiful young woman there, and he fell in love with her at the first sight“. (paragraph 5).\nHer is refers to …",
            "Sangkuriang was furious and kicked the boat. What is the closest meaning of the furious word?",
            "What did Sangkuriang do to the dog when he got nothing to hunt?",
            "She was beautiful and kind-hearted. Her hobby was weaving cloth. But ……. she could be very lazy.",
            "Who did break the promise ?",
            "What was the Crocodille name ?",
            "Where did sura look for some food ?",
            "What was the Shark’s name ?",
            "How many characters were there in the story Surabaya?"
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
            "do - laugh", "did - laugh", "are- laugh", "were - laughing",
            "Sangkuriang's grandmoter", "Sangkuriang's mother", "Sangkuriang's father", "Sangkuriang's wife",
            "Dayang Sumbi", "Sangkuriang's mother", "Tumang's wife", "Tumang's mother",
            "hurry", "excited", "angry", "happy",
            "He left the dog in the forest.", "He told the dog to go home.", "He killed the dog.", "He did nothing to the dog",
            "somewhere", "sometimes", "someone", "something",
            "Sura", "Tumang", "Sumbi", "Baya",
            "Tumang", "Baya", "Sura", "Sura",
            "beach", "forest", "river", "sea",
            "Sura", "Tumang", "Sumbi", "Baya",
            "4", "3", "2", "1",
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
            "were - laugh",
            "Sangkuriang's wife",
            "Dayang Sumbi",
            "angry",
            "He killed the dog.",
            "sometimes",
            "Sura",
            "Baya",
            "river",
            "Sura",
            "2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_soal);

        //Diskripsi:
        quis = findViewById(R.id.quis);
        radiogroup = findViewById(R.id.radioGroup);
        pilihA = findViewById(R.id.pilihA);
        pilihB = findViewById(R.id.pilihB);
        pilihC = findViewById(R.id.pilihC);
        pilihD = findViewById(R.id.pilihD);

        Typeface q = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        quis.setTypeface(q);
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

        quis.setText(pertanyaan[nomor]);
        pilihA.setText(pilih_jawaban[0]);
        pilihB.setText(pilih_jawaban[1]);
        pilihC.setText(pilih_jawaban[2]);
        pilihD.setText(pilih_jawaban[3]);

    }

    public void next(View view) {
        if (pilihA.isChecked() || pilihB.isChecked() || pilihC.isChecked() || pilihD.isChecked()) {
            RadioButton jawaban_user = findViewById(radiogroup.getCheckedRadioButtonId());
            String ambil_jawaban = jawaban_user.getText().toString();
            radiogroup.check(0);
            if (ambil_jawaban.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan.length) {
                quis.setText(pertanyaan[nomor]);
                pilihA.setText(pilih_jawaban[(nomor*4)+0]);
                pilihB.setText(pilih_jawaban[(nomor*4)+1]);
                pilihC.setText(pilih_jawaban[(nomor*4)+2]);
                pilihD.setText(pilih_jawaban[(nomor*4)+3]);

            } else {
                hasil = benar * 5;
                finish();
                Intent selesai = new Intent(getApplicationContext(), score_kuis.class);
                startActivity(selesai);
            }
        }
        else
        {
            Toast.makeText(this, "Pilih Jawaban Terlebih Dahulu!", Toast.LENGTH_SHORT).show();
        }
    }

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
