package com.example.imagensfelpudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);


        ImageView icone = findViewById(R.id.meuIcone);
        TextView titulo = findViewById(R.id.meuTitulo);
        TextView descricao = findViewById(R.id.meuDescricao);

        Bundle extras = getIntent().getExtras();


        if(extras != null)
        {
            String impTitulo = extras.getString("titulo");
            String impDescricao = extras.getString("descricao");
            int impIcone = extras.getInt("icone");

            icone.setImageResource(impIcone);
            titulo.setText(impTitulo);
            descricao.setText(impDescricao);
        }
    }
}
