package br.com.senaigo.mobile.restn2.rest.Service;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import br.com.senaigo.mobile.restn2.rest.model.Pedido;
import br.com.senaigo.mobile.restn2.rest.model.Pedido;

public class HTTPService extends AsyncTask<Void, Void, Pedido> {

    private final  String pedido;

    public HTTPService(String pedidos) {
        this.pedido = pedidos;
    }


    @Override
    protected Pedido doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("http://localhost:8080/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(5000);
            connection.connect();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNextLine()){
                resposta.append(scanner.nextLine());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(resposta.toString(), Pedido.class);
    }
}
