
package com.example.adilson.airlinetom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecusadoActivity extends AppCompatActivity {

    Button btnfechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recusado);

        btnfechar = findViewById(R.id.btnfechar);

        btnfechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //Intent itn = new Intent(getApplicationContext(),CartaoActivity.class);
                //startActivity(itn);

            }
        });
    }
}
