package br.com.local.sqliteappempregados;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produtos> {

    //Variaveis globais
    Context mCtx;
    int listaLayoutRes;
    List<Produtos> listaProdutos;
    SQLiteDatabase meuBancoDeDados;

    //Construtor da classe
    public ProdutoAdapter(Context mCtx, int listaLayoutRes, List<Produtos> listaProdutos, SQLiteDatabase meuBancoDeDados) {
        super(mCtx, listaLayoutRes, listaProdutos);

        this.mCtx = mCtx;
        this.listaLayoutRes = listaLayoutRes;
        this.listaProdutos = listaProdutos;
        this.meuBancoDeDados = meuBancoDeDados;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listaLayoutRes, null);

        final Produtos produtos = listaProdutos.get(position);

        TextView txtViewNome, txttViewTipo, txtViewPreco, txtViewDataEntrada;

        txtViewNome = view.findViewById(R.id.txtNomeViewFuncionario);
        txttViewTipo = view.findViewById(R.id.txtDepartamentoViewfuncionario);
        txtViewPreco = view.findViewById(R.id.txtSalarioViewFuncionario);
        txtViewDataEntrada = view.findViewById(R.id.txtEntradaviewFuncionario);

        txtViewNome.setText(produtos.getNome());
        txttViewTipo.setText(produtos.getTipo());
        txtViewPreco.setText(String.valueOf(produtos.getPreco()));
        txtViewDataEntrada.setText(produtos.getDataEntrada());

        Button btnExcluir, btnEditar;

        btnExcluir = view.findViewById(R.id.btnExcluirViewFuncionario);
        btnEditar = view.findViewById(R.id.btnEditarViewFuncionario);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alterarProdutos(produtos);
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                builder.setTitle("Deseja excluir?");
                builder.setIcon(R.drawable.outline_cancel);
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String sql = "DELETE FROM produtos WHERE id = ?";

                        meuBancoDeDados.execSQL(sql, new Integer[]{produtos.getId()});
                        recarregarProdutosDB();
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //somente vai voltar para tela.
                        recarregarProdutosDB();

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return view;


    }

    public void alterarProdutos(final Produtos produtos) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);

        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View view = inflater.inflate(R.layout.caixa_alterar_produto, null);
        builder.setView(view);

        final EditText txtEditarProduto = view.findViewById(R.id.txtEditarProduto);
        final EditText txtEditarPrice = view.findViewById(R.id.txtEditarPreco);
        final Spinner spnProdutos = view.findViewById(R.id.spnProdutos);

        txtEditarProduto.setText(produtos.getNome());
        txtEditarPrice.setText(String.valueOf(produtos.getPreco()));

        //Criando o janela de diálogo
        final AlertDialog dialog = builder.create();
        //Mostrando a janela de diálogo
        dialog.show();

        view.findViewById(R.id.btnAlterarProjeto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = txtEditarProduto.getText().toString().trim();
                String preco = txtEditarPrice.getText().toString().trim();
                String tipo = spnProdutos.getSelectedItem().toString().trim();

                if (nome.isEmpty()) {
                    txtEditarProduto.setError("Nome está em branco");
                    txtEditarProduto.requestFocus();
                    return;
                }
                if (preco.isEmpty()) {
                    txtEditarPrice.setError("Preço está em branco");
                    txtEditarPrice.requestFocus();
                    return;
                }

                String sql = "UPDATE produtos SET nome = ?, tipo = ?, preco = ? WHERE id = ?";
                meuBancoDeDados.execSQL(sql,
                        new String[]{nome, tipo, preco, String.valueOf(produtos.getId())});
                Toast.makeText(mCtx, "Produto alterado com sucesso!!!", Toast.LENGTH_LONG).show();

                recarregarProdutosDB();

                dialog.dismiss();
            }
        });

    }

    //Realizar um select na tabela
    public void recarregarProdutosDB() {
        Cursor cursorProdutos = meuBancoDeDados.rawQuery("SELECT * FROM produtos", null);
        if (cursorProdutos.moveToFirst()) {
            listaProdutos.clear();
            do {
                listaProdutos.add(new Produtos(
                        cursorProdutos.getInt(0),
                        cursorProdutos.getString(1),
                        cursorProdutos.getString(2),
                        cursorProdutos.getString(3),
                        cursorProdutos.getDouble(4)
                ));
            } while (cursorProdutos.moveToNext());
        }
        cursorProdutos.close();
        notifyDataSetChanged();
    }


}
