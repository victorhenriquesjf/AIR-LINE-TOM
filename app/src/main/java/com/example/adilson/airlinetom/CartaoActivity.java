package com.example.adilson.airlinetom;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adilson.airlinetom.Model.CartaoCredito;
import com.example.adilson.airlinetom.Model.Poltrona;
import com.example.adilson.airlinetom.Service.CartaoService;
import com.example.adilson.airlinetom.Service.ReservarPoltronaService;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class CartaoActivity extends AppCompatActivity {

    String valor;
    EditText edtnumerocartao,edtmes,edtano,edttarja;
    TextView txtvalor2;
    Button btnpagar;
    String resp="",resp2="";
    String numero,mes,ano,tarja;
    CartaoCredito cartaodeCredito;
    Poltrona poltrona;
    MediaPlayer mp;
    String token="",idV="",idP="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao);
        binding();
        valor = (String) getIntent().getSerializableExtra("valor");

        token = (String)getIntent().getSerializableExtra("token");

        idV = (String)getIntent().getSerializableExtra("idV");

        idP = (String)getIntent().getSerializableExtra("idP");

        txtvalor2.setText(valor.toString());


        btnpagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(CartaoActivity.this, R.raw.dim);
                mp.start();

                Gson gson = new Gson();


                numero = edtnumerocartao.getText().toString();
                mes = edtmes.getText().toString();
                ano = edtano.getText().toString();
                tarja = edttarja.getText().toString();

                try {
                    resp = new CartaoService().execute(numero,mes,ano,tarja,valor).get();
                    cartaodeCredito = gson.fromJson(resp, CartaoCredito.class);



                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                String Resultado = cartaodeCredito.getStatus();

                if(Resultado.equals("APROVADO")){

                    try {
                        resp2 = new ReservarPoltronaService().execute(idV,idP,token).get();

                        if(resp2.equals("200")){

                            Intent itn = new Intent(getApplicationContext(),AprovadoActivity.class);
                            startActivity(itn);
                       }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                }else if (Resultado.equals("REPROVADO")){

                    Intent itn = new Intent(getApplicationContext(),RecusadoActivity.class);
                    startActivity(itn);

                }

            }
        });

    }

    private void binding() {
        edtnumerocartao = findViewById(R.id.edtnumerocartao);
        edtmes = findViewById(R.id.edtmes);
        edtano = findViewById(R.id.edtano);
        edttarja = findViewById(R.id.edttarja);
        txtvalor2 = findViewById(R.id.txtvalor2);
        btnpagar = findViewById(R.id.btnpagar);
    }
}
