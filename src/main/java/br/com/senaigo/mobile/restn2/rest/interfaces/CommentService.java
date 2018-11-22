package br.com.senaigo.mobile.restn2.rest.interfaces;

import java.util.List;

import br.com.senaigo.mobile.restn2.rest.model.Comments;
import br.com.senaigo.mobile.restn2.rest.model.Pedido;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CommentService {

    @GET("comments/find/{comments}/json")
    Call<Comments> buscarComment(@Path("comments") Integer userId);

    @POST("comments/find/{comments}/json")
    Call<Comments> savePost(@Path("comments") Integer userId);

    @PUT("comments/find/{comments}/json")
    Call<Comments> savePut(@Path("comments") Integer userId);

    @DELETE("comments/find/{comments}/json")
    Call<Void> delete(@Path("comments") Integer userId);
}
