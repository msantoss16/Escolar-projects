//Classe utilizada para testar a aplicação
package psv;

import java.sql.*;
import java.util.*;

public class TestaCarro {

    public static void main(String[] args) {

        Connection con = Conexao.abrirConexao();

        //Instanciando o CarroBean e CarroDAO
        CarroBean cb = new CarroBean();
        CarroDAO cd = new CarroDAO(con);

        //Inserindo valores na tabela
        cb.setPlaca("DHG8524");
        cb.setCor("Preto");
        cb.setDescricao("Brasilia");

        //Executar o comando de insert
        System.out.println(cd.inserirCarro(cb));
        //Excluir um carro
        /*cb.setPlaca("ACE8978");
        System.out.println(cd.excluirCarro(cb));*/
        //Pesquisando os carros registrados no banco de dados
        List<CarroBean> lista = cd.listarTodos();

        if (lista != null) {

            for (CarroBean carro : lista) {
                System.out.println("Placa: " + carro.getPlaca());
                System.out.println("Cor: " + carro.getCor());
                System.out.println("Descrição: " + carro.getDescricao());
                System.out.println("");

            }
        }
    }

}

