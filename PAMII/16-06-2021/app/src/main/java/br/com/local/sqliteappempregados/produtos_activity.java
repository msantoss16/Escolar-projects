package br.com.local.sqliteappempregados;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class produtos_activity extends AppCompatActivity {

    List<Produtos> produtosList;
    ProdutoAdapter produtoAdapter;
    SQLiteDatabase meuBancoDeDados;
    ListView listViewProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produtos_layout);

        listViewProdutos = findViewById(R.id.listarProdutosView);

        produtosList = new ArrayList<>();

        meuBancoDeDados = openOrCreateDatabase(MainActivity.NOME_BANCO_DE_DADOS, MODE_PRIVATE, null);

        visualizarProdutosDatabase();
    }

    //Executar um select na tabela do banco de dados
    private void visualizarProdutosDatabase() {

        Cursor cursorProdutos = meuBancoDeDados.rawQuery("SELECT * FROM produtos", null);

        if (cursorProdutos.moveToFirst()) {
            do {
                produtosList.add(new Produtos(
                        cursorProdutos.getInt(0),
                        cursorProdutos.getString(1),
                        cursorProdutos.getString(2),
                        cursorProdutos.getString(3),
                        cursorProdutos.getDouble(4)
                ));
            } while (cursorProdutos.moveToNext());
        }
        cursorProdutos.close();

        //Verificar o layout
        produtoAdapter = new ProdutoAdapter(this, R.layout.lista_view_produtos, produtosList, meuBancoDeDados);

        //carregando o adaptador na listView
        listViewProdutos.setAdapter(produtoAdapter);
    }
}