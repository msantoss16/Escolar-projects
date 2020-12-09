/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package content;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Matheus
 */
public class ClienteDAO {
    private Connection con;
    
    public ClienteDAO(Connection con) {
        this.con = con;
    }
    
    public Connection getCon() {
        return con;
    }
    
    public void setCon(Connection con) {
        this.con = con;
    }
    
    public String inserirCliente(ClienteBean cliente) {

        String sql = "insert into tbcliente(nome,telResidencial,telComercial, telCelular, email)values(?,?,?,?,?)";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            //Inserir os valores do java no sql
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelRes());
            ps.setString(3, cliente.getTelCom());
            ps.setString(4, cliente.getTelCel());
            ps.setString(5, cliente.getEmail());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!!!";
            } else {
                return "Erro ao inserir!!!";
            }

        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String alterarCliente(ClienteBean cliente) {

        //Alterando os registros inseridos no bd
        String sql = "update tbcliente set nome = ?, telResidencial = ?, telComercial = ?, telCelular = ?, email = ? where id = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelRes());
            ps.setString(3, cliente.getTelCom());
            ps.setString(4, cliente.getTelCel());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, ""+cliente.getId());

            if (ps.executeUpdate() > 0) {

                return "Alterado com sucesso!!!";

            } else {
                return "Erro ao alterar!!!";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }

    }
    
    public String excluirCliente(ClienteBean cliente) {

        String sql = "delete from tbcliente where id = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, ""+cliente.getId());

            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso!!!";
            } else {
                return "Erro ao escluir!!!";
            }

        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
     
    //Criar o select
    public List<ClienteBean> listarTodos() {

        String sql = "select * from tbcliente";

        //Criando um vetor ou matriz vazia para carregar os valores do bd
        List<ClienteBean> listaClientes = new ArrayList<>();

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    ClienteBean cb = new ClienteBean();
                    cb.setId(Integer.parseInt(rs.getString(1)));
                    cb.setNome(rs.getString(2));
                    cb.setTelRes(rs.getString(3));
                    cb.setTelCom(rs.getString(4));
                    cb.setTelCel(rs.getString(5));
                    cb.setEmail(rs.getString(6));

                    listaClientes.add(cb);
                }
                return listaClientes;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            return null;
        }

    }
}
