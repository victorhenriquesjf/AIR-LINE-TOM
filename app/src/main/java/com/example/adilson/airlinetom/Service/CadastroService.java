package com.example.adilson.airlinetom.Service;

import android.os.AsyncTask;
import android.util.Log;

import com.example.adilson.airlinetom.Model.Usuario;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CadastroService extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... param) {

        // Create URL
        URL url = null;
        try {
            url = new URL("https://service.davesmartins.com.br/api/usuarios");
            //url = new URL("http://localhost:8080/api/usuarios/login");

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setReadTimeout(95 * 1000);
            urlConnection.setConnectTimeout(95 * 1000);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("X-Environment", "android");

            // Create the data
            Usuario ul = new Usuario(param[0],1,param[1],param[2],param[3]);
            String user = new Gson().toJson(ul);




          // String user ="{\"email\":\""+param[0]+"\","+"\"id\":\""+1+"\","+"\""+"\"login\":\""+param[1]+"\","+"\""+"\"nome\":\""+param[2]+"\","+"\""+"\"senha\":\""+param[3]+"\"}";
            //Log.i("UIUIU", "doInBackground: "+user);
            urlConnection.setDoOutput(true);
             urlConnection.getOutputStream().write(user.getBytes());


            String finalJson = "";
            int teste  = urlConnection.getResponseCode();
            if (urlConnection.getResponseCode() == 200) {
                InputStream responseBody = urlConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                BufferedReader reader = new BufferedReader(responseBodyReader);
                StringBuffer buffer = new StringBuffer();
                String line ="";

                while ((line=reader.readLine())!=null){
                    buffer.append(line);
                }

                finalJson = buffer.toString();
            } else {
                finalJson = urlConnection.getResponseCode()+"";
            }

            return finalJson;

        } catch (MalformedURLException e) {
            return "Erro1: "+e.getMessage();
        } catch (IOException e) {
            return "Erro2: "+e.getMessage();
        }

    }
}
