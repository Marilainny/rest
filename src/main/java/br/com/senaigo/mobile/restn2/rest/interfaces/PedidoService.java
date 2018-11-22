package br.com.senaigo.mobile.restn2.rest.interfaces;

import br.com.senaigo.mobile.restn2.rest.model.Pedido;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface PedidoService {

    @GET("pedido/find/{pedido}/json")
    Call<Pedido> buscarPedido(@Path("pedido") Integer pedido);
}
