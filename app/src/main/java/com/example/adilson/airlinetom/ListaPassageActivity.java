package com.example.adilson.airlinetom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adilson.airlinetom.Model.Passagem;
import com.example.adilson.airlinetom.Model.Poltrona;
import com.example.adilson.airlinetom.Model.Usuario;
import com.example.adilson.airlinetom.Model.Voo;
import com.example.adilson.airlinetom.Service.PassagensService;
import com.example.adilson.airlinetom.Service.PoltronaService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListaPassageActivity extends AppCompatActivity {
    String user="";
    Usuario usuario,usuario2;
    ListView lstPassagens;
    String resp="",token="";
    long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_passage);

        lstPassagens = findViewById(R.id.lstPassagens);
        Gson gson = new Gson();

        user = (String)getIntent().getSerializableExtra("usuario");
        token = (String)getIntent().getSerializableExtra("token");
        usuario = gson.fromJson(user, Usuario.class);

         id = usuario.getId();
        try {

            resp = new PassagensService().execute(String.valueOf(id),token).get();
            usuario2 = gson.fromJson(resp, Usuario.class);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Erro no serviço: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }



            String[] vet = new String[usuario2.getPassagens().size()];
            int i=0;
            for(Passagem p: usuario2.getPassagens()){
                vet[i] = String.valueOf("Numero Assento: "+p.getAssento()+" Destino: "+p.getDestino()+" Data: "+p.getDataVoo());
                i++;
            }


            ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,vet);
            lstPassagens.setAdapter(adapter);

    }
}
