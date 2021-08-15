package com.example.mylegend;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import androidx.appcompat.app.AppCompatActivity;

public class SimplepastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplepast);

        ImageButton btn_close = findViewById(R.id.btnClose);
        ImageButton btn_next = findViewById(R.id.btnNext);
        TextView txt = findViewById(R.id.txtSim);
        TextView txt2 = findViewById(R.id.txtSim2);
        TextView txt3 = findViewById(R.id.txtSim3);
        PhotoView photoView = findViewById(R.id.photo);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.ytbPlaysimple);

        Typeface q = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt.setTypeface(q);

        Typeface q2 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt2.setTypeface(q2);

        Typeface q3 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        txt3.setTypeface(q3);

        photoView.setImageResource(R.drawable.tabell);

        youTubePlayerView.isFullScreen();
        getLifecycle().addObserver(youTubePlayerView);

        btn_close.setOnClickListener(view -> finish());

        btn_next.setOnClickListener(view -> {
            finish();
            Intent i = new Intent(SimplepastActivity.this, SimplepastActivity2.class);
            startActivity(i);
        });

    }
}