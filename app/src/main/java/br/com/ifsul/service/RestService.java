package br.com.ifsul.service;

import br.com.ifsul.response.YesOrNoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestService {

    @GET("api")
    Call<YesOrNoResponse> perguntar();
}
