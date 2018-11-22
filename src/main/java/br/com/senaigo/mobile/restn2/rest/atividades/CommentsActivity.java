package br.com.senaigo.mobile.restn2.rest.atividades;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.senaigo.mobile.restn2.rest.R;
import br.com.senaigo.mobile.restn2.rest.configuracao.RetrofitConfig;
import br.com.senaigo.mobile.restn2.rest.model.Comments;
import br.com.senaigo.mobile.restn2.rest.model.Pedido;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etId= findViewById(R.id.etMain_id);
        final TextView tvResposta = findViewById(R.id.etMain_resposta);

        Button botao = findViewById(R.id.btnMain_buscarComment);

        botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Call call = new RetrofitConfig().getCommentService().buscarComment (Integer.valueOf(etId.getText().toString()));

                call.enqueue(new Callback<Comments>() {

                    @Override
                    public void onResponse(Call<Comments> call, Response<Comments> response) {
                        Comments coments = response.body();
                        tvResposta.setText(coments.toString());
                    }

                    @Override
                    public void onFailure(Call<Comments> call, Throwable t) {
                        Log.e("PedidoService   ", "Erro ao buscar o comments:" + t.getMessage());

                    }

                });
            }

        });
    }
}
