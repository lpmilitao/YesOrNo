package br.com.ifsul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RespostaActivity extends AppCompatActivity {

    private ImageView respostaImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        String intent = getIntent().getStringExtra("resposta");

        respostaImagem = findViewById(R.id.respostaImagem);
        System.out.println(intent);
        if (intent.equalsIgnoreCase("yes")){
            respostaImagem.setImageDrawable(getDrawable(R.drawable.yes));
        } else {
            respostaImagem.setImageDrawable(getDrawable(R.drawable.no));
        }
    }
}