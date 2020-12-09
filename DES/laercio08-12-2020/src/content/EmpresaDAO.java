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
public class EmpresaDAO {
    private Connection con;
    
    public EmpresaDAO(Connection con) {
        this.con = con;
    }
    
    public Connection getCon() {
        return con;
    }
    
    public void setCon(Connection con) {
        this.con = con;
    }
    
    public String inserirEmpresa(EmpresaBean empresa) {

        String sql = "insert into tbempresa(codigo, nomeEmpresa, cnpj, razaoSocial)values(?,?,?,?)";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            //Inserir os valores do java no sql
            ps.setString(1, empresa.getCodigo());
            ps.setString(2, empresa.getNomeEmpresa());
            ps.setString(3, empresa.getCnpj());
            ps.setString(4, empresa.getRazaoSocial());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!!!";
            } else {
                return "Erro ao inserir!!!";
            }

        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    //Criar o select
    public List<EmpresaBean> listarTodos() {

        String sql = "select * from tbempresa";

        //Criando um vetor ou matriz vazia para carregar os valores do bd
        List<EmpresaBean> listaEmpresas = new ArrayList<>();

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    EmpresaBean cb = new EmpresaBean();
                    cb.setCodigo(rs.getString(1));
                    cb.setNomeEmpresa(rs.getString(2));
                    cb.setCnpj(rs.getString(3));
                    cb.setRazaoSocial(rs.getString(4));

                    listaEmpresas.add(cb);
                }
                return listaEmpresas;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            return null;
        }
    }
    
    public String excluirEmpresa(EmpresaBean empresa) {

        String sql = "delete from tbempresa where codigo = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, empresa.getCodigo());

            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso!!!";
            } else {
                return "Erro ao escluir!!!";
            }

        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String alterarEmpresa(EmpresaBean empresa) {

        //Alterando os registros inseridos no bd
        String sql = "update tbempresa set codigo = ?, nomeEmpresa = ?, cnpj = ?, razaoSocial = ? where codigo = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, empresa.getCodigo());
            ps.setString(2, empresa.getNomeEmpresa());
            ps.setString(3, empresa.getCnpj());
            ps.setString(4, empresa.getRazaoSocial());
            ps.setString(5, empresa.getCodigo());

            if (ps.executeUpdate() > 0) {

                return "Alterado com sucesso!!!";

            } else {
                return "Erro ao alterar!!!";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }

    }
}
    
