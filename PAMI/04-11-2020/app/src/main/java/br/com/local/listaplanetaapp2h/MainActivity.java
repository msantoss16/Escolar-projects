package br.com.local.listaplanetaapp2h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declarar a variável que irá receber a ListView do XML
    ListView listView;
    //Criar os arrays que serão inseridos na listView

    String nomeLivros[] = {"Nórdicos", "Ibiza Bohemia", "Lady Killers", "O Labirinto do Fauno",
            "Mindset", "Alice no País das \nMaravilhas", "Medicina Macabra", "O Colecionador",
            "Orgulho e Preconceito", "Misery", "Joyland", "Outsider",
            "Admirável mundo novo", "As outras pessoas", "O poder do hábito", "O poder da ação",
            "O poder do agora", "As armas da persuasão", "A coragem de ser imperfeito", "Quem pensa enriquece"};

    int imgLivros[] = {R.drawable.nordicos, R.drawable.ibizabohemia,
            R.drawable.ladykillers, R.drawable.labirintodofauno, R.drawable.mindset,
            R.drawable.alicenopaisdasmaravilhas, R.drawable.medicinamacabra, R.drawable.ocolecionador,
            R.drawable.orgulhoepreconceito, R.drawable.misery, R.drawable.joyland,
            R.drawable.outsider, R.drawable.admiravelmundonovo, R.drawable.asoutraspessoas,
            R.drawable.opoderdohabito, R.drawable.opoderdaacao, R.drawable.opoderdoagora,
            R.drawable.asarmasdapersuassao, R.drawable.acoragemdeserimperfeito, R.drawable.quempensaenriquece};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //a variavel listview está recebendo a listView XML
        listView = findViewById(R.id.listaPlanetas);

        //Criar o objeto/classe que irá inserir o modelo na listView

        CustomAdapter customAdapter = new CustomAdapter();

        //Carregar o baseAdapter na listView
        listView.setAdapter(customAdapter);

        //Criando evento de click na listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),VisualizaPlaneta_MainActivity.class);
                //Passando valores de uma janela para outra
                intent.putExtra("nomeLivro",nomeLivros[i]);
                intent.putExtra("imagemLivro",imgLivros[i]);

                startActivity(intent);

            }
        });


    }

    //inner class - Classe dentro de outra Classe
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgLivros.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Montar o modelo para ser inserido na lista de planetas - ListView
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView txtNomeLivros;
            ImageView imagemLivros;

            //instanciando o modelo com os componentes para inserir na Lista
            View carregaView = getLayoutInflater().inflate(R.layout.modelo_lista_planetas, null);

            txtNomeLivros = carregaView.findViewById(R.id.txtListaPlaneta);
            imagemLivros = carregaView.findViewById(R.id.imgListaPlaneta);

            //Carregando os valores nos componentes

            txtNomeLivros.setText(nomeLivros[i]);
            imagemLivros.setImageResource(imgLivros[i]);

            return carregaView;
        }
    }
}