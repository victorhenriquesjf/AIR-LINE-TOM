package com.example.adilson.airlinetom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adilson.airlinetom.Model.Passagem;
import com.example.adilson.airlinetom.Model.Poltrona;
import com.example.adilson.airlinetom.Model.Voo;
import com.example.adilson.airlinetom.Service.PoltronaService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PoltronaActivity extends AppCompatActivity {
    ListView lstPoltronas;
    String resp="",token="",idV="";
    String valor;
    List<Poltrona> poltronaList;
    List<Poltrona> poltronaListAux = new ArrayList<>();
    Poltrona poltrona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poltrona);
        binding();

        token = (String)getIntent().getSerializableExtra("token");
        idV = (String)getIntent().getSerializableExtra("idV");
        valor = (String) getIntent().getSerializableExtra("valor");

        Gson gson = new Gson();

        try {
            resp = new PoltronaService().execute(idV,token).get();
            Type collectionType = new TypeToken<List<Poltrona>>() {}.getType();
            poltronaList = gson.fromJson(resp, collectionType);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Erro no serviço: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }

        List<String> vet = new ArrayList<>();
        int i=0;

        for(Poltrona p: poltronaList){
            if(!poltronaList.get(i).isOcupado()){
                vet.add(String.valueOf("Assento Livre: "+ p.getAssento()));
                poltronaListAux.add(p);
            }
            i++;
        }


        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,vet);
        lstPoltronas.setAdapter(adapter);

        lstPoltronas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String idpoltrona = poltronaListAux.get(position).getAssento();


                Intent itn = new Intent(getApplicationContext(),CartaoActivity.class);
                itn.putExtra("valor",valor);
                itn.putExtra("token",token);
                itn.putExtra("idV",idV);
                itn.putExtra("idP",idpoltrona);
                startActivity(itn);

            }
        });
    }



    private void binding() {
        lstPoltronas = findViewById(R.id.lstPoltronas);
    }
}