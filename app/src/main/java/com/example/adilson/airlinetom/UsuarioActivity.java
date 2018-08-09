package com.example.adilson.airlinetom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.adilson.airlinetom.Service.CadastroService;
import com.example.adilson.airlinetom.Service.LoginService;

import java.util.concurrent.ExecutionException;

public class UsuarioActivity extends AppCompatActivity {

    EditText edtnome,edtlogin,edtsenha,edtemail;
    ImageButton btnvoltar,btncadastrar;
    String resp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        binding();

        aoclicarvoltar();

        aoclicarcadastrar();
    }

    private void aoclicarcadastrar() {
        btncadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    resp = new CadastroService().execute(edtemail.getText().toString(),
                     edtlogin.getText().toString(),edtnome.getText().toString(),edtsenha.getText().toString()).get();
                    Intent itn = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(itn);
                } catch (Exception e) {
                    e.getMessage();
                }


            }
        });
    }

    private void aoclicarvoltar() {
        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent itn = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(itn);
            }
        });
    }

    private void binding() {

        edtnome = findViewById(R.id.edtnome);
        edtlogin = findViewById(R.id.edtlogin);
        edtsenha = findViewById(R.id.edtsenha);
        edtemail = findViewById(R.id.edtemail);
        btnvoltar = findViewById(R.id.btnvoltar);
        btncadastrar = findViewById(R.id.btncadastrar);

    }
}
