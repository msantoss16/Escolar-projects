//Classe para acesso ao objeto
package psv;

public class CarroBean {
    
    //Atributos da classe
    
    private String placa;
    private String cor;
    private String descricao;
    
    //Criando o construtores

    public CarroBean() {
    }
       
    //Criar os métodos getters e setters - alt+insert

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
