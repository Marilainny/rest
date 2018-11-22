package br.com.senaigo.mobile.restn2.rest.atividades;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import br.com.senaigo.mobile.restn2.rest.R;
import br.com.senaigo.mobile.restn2.rest.Service.HTTPService;
import br.com.senaigo.mobile.restn2.rest.configuracao.RetrofitConfig;
import br.com.senaigo.mobile.restn2.rest.interfaces.PedidoService;
import br.com.senaigo.mobile.restn2.rest.model.Pedido;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etPedido = findViewById(R.id.etMain_pedido);
        final TextView tvResposta = findViewById(R.id.etMain_resposta);

        Button botao = findViewById(R.id.btnMain_buscarPedido);

        botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Call call = new RetrofitConfig().getPedidoService().buscarPedido(Integer.valueOf(etPedido.getText().toString()));

                 call.enqueue(new Callback<Pedido>() {

                    @Override
                    public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                        Pedido pedido = response.body();
                        tvResposta.setText(pedido.toString());
                    }

                    @Override
                    public void onFailure(Call<Pedido> call, Throwable t) {
                        Log.e("PedidoService   ", "Erro ao buscar o pedido:" + t.getMessage());

                    }
                });
            }

        });


   /*  Sem usar o retrofit

    botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etPedido.getText().toString().length() > 0 && !etPedido.getText().toString().equals("")) {

                    HTTPService service = new HTTPService(etPedido.getText().toString());
                    try {
                       Pedido retorno = service.execute().get();
                       tvResposta.setText(retorno.toString());
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        });*/

    }

}
