package br.com.local.sqliteappempregados;

public class Produtos {

    //variaveis que representam os campos do banco de dados
    private int id;
    private String nome, tipo, dataEntrada;
    private double preco;

    //Construtor da classe
    public Produtos(int id, String nome, String tipo, String dataEntrada, double preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.dataEntrada = dataEntrada;
        this.preco = preco;
    }

    //criando os métodos de acesso getter e setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
