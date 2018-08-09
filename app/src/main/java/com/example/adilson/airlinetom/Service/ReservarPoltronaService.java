package com.example.adilson.airlinetom.Service;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ReservarPoltronaService extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... param) {

        // Create URL
        URL url = null;
        try {
            url = new URL("https://service.davesmartins.com.br/api/voo/"+param[0]+"/"+"poltronas"+"/"+param[1]);
            //url = new URL("http://localhost:8080/api/usuarios/login");
            //https://service.davesmartins.com.br/api/voo/7/poltronas/6

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("PUT");
            urlConnection.setReadTimeout(95 * 1000);
            urlConnection.setConnectTimeout(95 * 1000);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("code", param[2]);
            urlConnection.setRequestProperty("X-Environment", "android");

            urlConnection.connect();

            String finalJson = "";
            if (urlConnection.getResponseCode() == 200) {
                InputStream responseBody = urlConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                BufferedReader reader = new BufferedReader(responseBodyReader);
                StringBuffer buffer = new StringBuffer();
                String line ="";

                while ((line=reader.readLine())!=null){
                    buffer.append(line);
                }

                finalJson = urlConnection.getResponseCode()+"";
            } else {
                finalJson = urlConnection.getResponseCode()+" "+
                urlConnection.getResponseMessage();
            }

            return finalJson;

        } catch (MalformedURLException e) {
            return "Erro1: "+e.getMessage();
        } catch (IOException e) {
            return "Erro2: "+e.getMessage();
        }

    }
}
