package br.com.local.sqliteappempregados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String NOME_BANCO_DE_DADOS = "dbTI97.db";

    TextView lblProdutos;
    EditText txtNomeProduto, txtprecoProduto;
    Spinner spnTipos;

    Button btnAdicionaProduto;

    //Declarando a variavel que terá todos os comandos do SQLite
    SQLiteDatabase meuBancoDeDados;

    //Create Database, Table
    //Insert, Select, Update, Delete

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblProdutos = findViewById(R.id.lblVisualizaProdutos);
        txtNomeProduto = findViewById(R.id.txtNomeNovoProduto);
        txtprecoProduto = findViewById(R.id.txtNovoPrecoProduto);
        spnTipos = findViewById(R.id.spnProdutos);

        btnAdicionaProduto = findViewById(R.id.btnAdicionarProduto);

        //Irá pegar a ação de click nos dois componentes
        btnAdicionaProduto.setOnClickListener(this);
        lblProdutos.setOnClickListener(this);

        //Criando banco de dados
        meuBancoDeDados = openOrCreateDatabase(NOME_BANCO_DE_DADOS, MODE_PRIVATE, null);

        //Criar as tabelas para o banco de dados
        criarTabelaProduto();

    }

//Este método irá validar o nome e o preco
    //tipo não precisa de validação, pois é um spinner e não pode estar vazio

    private boolean verificarEntrada(String nome, String preco) {
        if (nome.isEmpty()) {
            txtNomeProduto.setError("Por favor entre com o nome");
            txtNomeProduto.requestFocus();
            return false;
        }

        if (preco.isEmpty() || Integer.parseInt(preco) <= 0) {
            txtprecoProduto.setError("Por favor entre com o preço");
            txtprecoProduto.requestFocus();
            return false;
        }
        return true;
    }

    //Neste método vamos fazer a operação para adicionar o produto
    private void adicionarProduto() {

        String nomeProd = txtNomeProduto.getText().toString().trim();
        String precoProd = txtprecoProduto.getText().toString().trim();
        String tipoProd = spnTipos.getSelectedItem().toString();

        // obtendo o horário atual para data de inclusão
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dataEntrada = simpleDateFormat.format(calendar.getTime());

        //validando entrada
        if (verificarEntrada(nomeProd, precoProd)) {


            String insertSQL = "INSERT INTO produtos (" +
                    "nome, " +
                    "tipo, " +
                    "dataEntrada," +
                    "preco)" +
                    "VALUES(?, ?, ?, ?);";

            // usando o mesmo método execsql para inserir valores
            // desta vez tem dois parâmetros
            // primeiro é a string sql e segundo são os parâmetros que devem ser vinculados à consulta

            meuBancoDeDados.execSQL(insertSQL, new String[]{nomeProd, tipoProd, dataEntrada, precoProd});

            Toast.makeText(getApplicationContext(), "Produto adicionado com sucesso!!!", Toast.LENGTH_SHORT).show();

            limparCadastro();

        }

    }

    //Limpar os campos apos cadastro
    public void limparCadastro() {

        txtNomeProduto.setText("");
        txtprecoProduto.setText("");
        txtNomeProduto.requestFocus();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAdicionarProduto:
                adicionarProduto();
                break;
            case R.id.lblVisualizaProdutos:
                startActivity(new Intent(getApplicationContext(), produtos_activity.class));
                break;
        }

    }
    // este método irá criar a tabela
    // como vamos chamar esse método toda vez que lançarmos o aplicativo
    // Eu adicionei IF NOT EXISTS ao SQL
    // então, só criará a tabela quando a tabela ainda não estiver criada


    private void criarTabelaProduto() {
        meuBancoDeDados.execSQL(
                "CREATE TABLE IF NOT EXISTS produtos (" +
                        "id integer PRIMARY KEY AUTOINCREMENT," +
                        "nome varchar(200) NOT NULL," +
                        "tipo varchar(200) NOT NULL," +
                        "dataEntrada datetime NOT NULL," +
                        "preco double NOT NULL );"
        );

    }

}