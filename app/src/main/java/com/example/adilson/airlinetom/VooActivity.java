package com.example.adilson.airlinetom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adilson.airlinetom.Model.Voo;
import com.example.adilson.airlinetom.Service.VooDetalheService;
import com.example.adilson.airlinetom.Service.VooService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class VooActivity extends AppCompatActivity {
    String token="",idV="",resp="";
    String valor;
    TextView txvCapacidade,txvModelo,txvPrefixo,txvDataVoo,txvAeroportoD,txvCidadeD,txvAeroportoO,txvCidadeO,txvValor;
    Voo voo;
    ImageButton btnPoltrona,imgbvoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voo);

        binding();

        token = (String)getIntent().getSerializableExtra("token");
        idV = (String)getIntent().getSerializableExtra("idV");
        Gson gson = new Gson();

        try {
            resp = new VooDetalheService().execute(idV.toString(),token.toString()).get();
            voo = gson.fromJson(resp, Voo.class);

            txvCapacidade.setText(String.valueOf(voo.getAviao().getCapacidade()));
            txvModelo.setText(voo.getAviao().getModelo());
            txvPrefixo.setText(voo.getAviao().getPrefixo());
            txvDataVoo.setText(voo.getDataVoo());
            txvAeroportoD.setText(voo.getDestino().getAeroporto());
            txvCidadeD.setText(voo.getDestino().getCidade());
            txvAeroportoO.setText(voo.getOrigem().getAeroporto());
            txvCidadeO.setText(voo.getOrigem().getCidade());
            txvValor.setText(String.valueOf(voo.getValorPassagem()));


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Erro no serviço: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }

        imgbvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            finish();
            }
        });

        btnPoltrona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valor = voo.getValorPassagem()+"";

                Intent itn = new Intent(getApplicationContext(),PoltronaActivity.class);
                itn.putExtra("idV",idV);
                itn.putExtra("token",token);
                itn.putExtra("valor",valor);

                startActivity(itn);
            }
        });
    }

    private void binding() {
        txvCapacidade = findViewById(R.id.txvCapacidade);
        txvModelo = findViewById(R.id.txvModelo);
        txvPrefixo = findViewById(R.id.txvPrefixo);
        txvDataVoo = findViewById(R.id.txvDataVoo);
        txvAeroportoD = findViewById(R.id.txvAeroportoD);
        txvCidadeD = findViewById(R.id.txvCidadeD);
        txvAeroportoO = findViewById(R.id.txvAeroportoO);
        txvCidadeO = findViewById(R.id.txvCidadeO);
        txvValor = findViewById(R.id.txvValor);
        btnPoltrona = findViewById(R.id.btnPoltrona);
        imgbvoltar= findViewById(R.id.imgbvoltar);
    }
}
