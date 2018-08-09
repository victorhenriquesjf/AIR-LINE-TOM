package com.example.adilson.airlinetom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adilson.airlinetom.Model.Usuario;
import com.example.adilson.airlinetom.Model.Voo;
import com.example.adilson.airlinetom.Service.LoginService;
import com.example.adilson.airlinetom.Service.PassagensService;
import com.example.adilson.airlinetom.Service.VooService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PesquisaActivity extends AppCompatActivity {
    ListView lsttodosvoos;
    ImageButton btnListPassagem;
    List<Voo> voos;
    String token="",resp = "",usuario="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        Gson json = new Gson();
        binding();

        token = (String)getIntent().getSerializableExtra("token");
        usuario = (String)getIntent().getSerializableExtra("usuario");


        try {
            resp = new VooService().execute(token).get();
            Type collectionType = new TypeToken<List<Voo>>() {}.getType();
            voos = json.fromJson(resp, collectionType);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Erro no serviço: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }


        String[] vet = new String[voos.size()];
        int i=0;
        for(Voo e: voos){
            vet[i] = String.valueOf(e.getOrigem().getCidade()+" - "+ e.getDestino().getCidade()+" - "+e.getDataVoo() );
            i++;
        }
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,vet);
        lsttodosvoos.setAdapter(adapter);


        lsttodosvoos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String idV = String.valueOf(voos.get(position).getId());

                Intent itn = new Intent(getApplicationContext(),VooActivity.class);
                itn.putExtra("idV",idV);
                itn.putExtra("token",token);

                startActivity(itn);
            }
        });

        btnListPassagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    Gson gson = new Gson();
                    Usuario u = gson.fromJson(usuario, Usuario.class);
                    resp = new PassagensService().execute(String.valueOf(u.getId()),token).get();

                    } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                if(resp !=null)
                {
                    Intent itn = new Intent(getApplicationContext(),ListaPassageActivity.class);
                    itn.putExtra("usuario",usuario);
                    itn.putExtra("token",token);
                    startActivity(itn);

                }else if(resp == null)
                {



                }


            }
        });
    }

    private void binding() {
        lsttodosvoos = findViewById(R.id.lsttodosvoos);
        btnListPassagem = findViewById(R.id.btnListPassagem);

    }
}
