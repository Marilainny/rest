package br.com.senaigo.mobile.restn2.rest.configuracao;

import br.com.senaigo.mobile.restn2.rest.interfaces.CommentService;
import br.com.senaigo.mobile.restn2.rest.interfaces.PedidoService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/comments")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public PedidoService getPedidoService() {
        return this.retrofit.create(PedidoService.class);
    }

    public CommentService getCommentService(){
        return  this.retrofit.create(CommentService.class);
    }

}
