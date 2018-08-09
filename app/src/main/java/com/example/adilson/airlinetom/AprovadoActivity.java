package com.example.adilson.airlinetom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AprovadoActivity extends AppCompatActivity {

    Button btnRetornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovado);

        btnRetornar = findViewById(R.id.btnRetornar);

        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent itn = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(itn);
            }
        });
    }
}
