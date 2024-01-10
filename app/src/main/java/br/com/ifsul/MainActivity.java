package br.com.ifsul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.ifsul.response.YesOrNoResponse;
import br.com.ifsul.service.RestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String URL = "https://yesno.wtf/";

    private Retrofit retrofit;
    private Button perguntarButton;
    private EditText pergunta;
    private String resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perguntarButton = findViewById(R.id.perguntar);
        pergunta = findViewById(R.id.pergunta);
        pergunta.setText("");

        retrofit = new Retrofit.Builder()
                .baseUrl(URL) // Endereço do webservice
                .addConverterFactory(GsonConverterFactory.create()) // Conversor para usar Gson
                .build();
    }

    public void onClick(View v) {
        consultar();
    }

    private void consultar() {
        RestService restService = retrofit.create(RestService.class);

        Call<YesOrNoResponse> call = restService.perguntar();

        call.enqueue(new Callback<YesOrNoResponse>() {
            @Override
            public void onResponse(Call<YesOrNoResponse> call, Response<YesOrNoResponse> response) {
                if (response.isSuccessful()) {
                    YesOrNoResponse responseyon = response.body();
                    resposta = responseyon.getAnswer();

                    Intent i = new Intent(getApplicationContext(), RespostaActivity.class);
                    i.putExtra("resposta", resposta);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<YesOrNoResponse> call, Throwable t) {
                resposta = "fail";
            }
        });
    }
}