package com.example.adilson.airlinetom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PrimeiraActivity extends AppCompatActivity {
 ImageView imageView;
 Button btnir;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);

        mp = MediaPlayer.create(PrimeiraActivity.this, R.raw.comandante2);
        mp.start();
        imageView = findViewById(R.id.imageView);
        btnir =  findViewById(R.id.btnir);


        btnir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itn = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(itn);
            }
        });

    }
}
