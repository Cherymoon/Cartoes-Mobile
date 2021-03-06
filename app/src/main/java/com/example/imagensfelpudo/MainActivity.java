package com.example.imagensfelpudo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    String[] listaNomes = {"Felpudo", "Fofura","Lesmo",
            "Bugado", "Uruca","Racing",
            "iOS", "Android","RealidadeAumentada",
            "Sound", "FX","3D", "Studio Max", "Games"
    };

    int[] listaIcones = {R.drawable.felpudo, R.drawable.fofura, R.drawable.lesmo, R.drawable.bugado,
            R.drawable.uruca, R.drawable.carrinho, R.drawable.ios, R.drawable.android,
            R.drawable.realidade_aumentada, R.drawable.sound_fx, R.drawable.sound_fx, R.drawable.max,
            R.drawable.max, R.drawable.games,
    };

    String[] listaDescricoes = {"Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras.",
            "Este é o protagonista dos nossos cursos de iOS e Android. Ele vive se metendo em muitas aventuras."
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView minhaLista = findViewById(R.id.minhaLista);

        final MeuAdaptador meuAdaptador;
        meuAdaptador = new MeuAdaptador(getApplicationContext(), R.layout.minha_celula);

        for(int i=0; i<listaNomes.length-1;i++) {
            DadosPersonagem dadosPersonagem;
            dadosPersonagem = new DadosPersonagem(listaIcones[i], listaNomes[i], listaDescricoes[i]);
            meuAdaptador.add(dadosPersonagem);
        }

        minhaLista.setAdapter(meuAdaptador);


        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DadosPersonagem dadosPersonagem;
                dadosPersonagem = (DadosPersonagem) meuAdaptador.getItem(position);

                Intent intent = new Intent(MainActivity.this, SegundaTela.class);
                intent.putExtra("titulo", dadosPersonagem.getTitulo());
                intent.putExtra("icone", dadosPersonagem.getIcone());
                intent.putExtra("descricao", dadosPersonagem.getDescricao());
                startActivity(intent);
            }
        });

    }
}

class DadosPersonagem {
    private int icone;
    private String titulo;
    private String descricao;

    public DadosPersonagem(int icone, String titulo, String descricao) {
        this.icone = icone;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getIcone() {
        return icone;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}

class ViewPersonagem {
    ImageView icone;
    TextView titulo;
    TextView descricao;
}

class MeuAdaptador extends ArrayAdapter {
    public MeuAdaptador(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View minhaView;
        minhaView = convertView;
        ViewPersonagem viewPersonagem;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            minhaView = inflater.inflate(R.layout.minha_celula, parent, false);

            viewPersonagem = new ViewPersonagem();
            viewPersonagem.icone = (ImageView) minhaView.findViewById(R.id.meuIcone);
            viewPersonagem.titulo = (TextView) minhaView.findViewById(R.id.meuTitulo);
            viewPersonagem.descricao = (TextView) minhaView.findViewById(R.id.meuDescricao);

            minhaView.setTag(viewPersonagem);
        }
        else {
            viewPersonagem = (ViewPersonagem) minhaView.getTag();
        }

        DadosPersonagem dadosPersonagem;
        dadosPersonagem = (DadosPersonagem) this.getItem(position);

        viewPersonagem.icone.setImageResource(dadosPersonagem.getIcone());
        viewPersonagem.titulo.setText(dadosPersonagem.getTitulo());


        return minhaView;
    }
}