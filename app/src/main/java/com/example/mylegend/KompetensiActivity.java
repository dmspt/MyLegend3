package com.example.mylegend;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KompetensiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompetensi);

        TextView tKom = findViewById(R.id.txtkom);
        TextView tKom2 = findViewById(R.id.txtkom2);
        TextView tKom3 = findViewById(R.id.txtkom3);
        TextView tKom4 = findViewById(R.id.txtkom4);

        Typeface kom = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom.setTypeface(kom);

        Typeface kom2 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom2.setTypeface(kom2);

        Typeface kom3 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom3.setTypeface(kom3);

        Typeface kom4 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom4.setTypeface(kom4);

    }

    public void close(View view)
    {
        super.onBackPressed();
    }

}