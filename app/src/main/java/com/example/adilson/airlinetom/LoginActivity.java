package com.example.adilson.airlinetom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.adilson.airlinetom.Model.Usuario;
import com.example.adilson.airlinetom.Model.Voo;
import com.example.adilson.airlinetom.Service.LoginService;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    ImageButton btnNovoUsuario, btnLogin;
    EditText edtSenha,edtLogin;
    String token,resp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding();
        AoclicarbotaoNovoUsuario();
        aoClicarBotaoLogin();
    }

    private void aoClicarBotaoLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    resp = new LoginService().execute(edtLogin.getText().toString(),edtSenha.getText().toString()).get();
                    token = resp.substring(resp.indexOf("token")+8,resp.indexOf("}")-1);

                } catch (Exception e) {
                    e.getMessage();
                }

                if(token !=null){
                    Intent itn = new Intent(getApplicationContext(),PesquisaActivity.class);
                    itn.putExtra("token",token);
                    itn.putExtra("usuario", resp);
                    startActivity(itn);
                }else
                {
                    Toast.makeText(getApplicationContext(),"Login ou senha incorretos", Toast.LENGTH_LONG).show();

                }



            }
        });
    }

    private void AoclicarbotaoNovoUsuario() {
        btnNovoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itn = new Intent(getApplicationContext(),UsuarioActivity.class);
                startActivity(itn);
            }
        });
    }

    private void binding() {
        btnNovoUsuario = findViewById(R.id.btnNovoUsuario);
        btnLogin = findViewById(R.id.btnLogin);
        edtSenha = findViewById(R.id.edtSenha);
        edtLogin = findViewById(R.id.edtLogin);
    }
}
