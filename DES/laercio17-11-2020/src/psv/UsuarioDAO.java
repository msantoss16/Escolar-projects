
package psv;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    
    private Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
     public String inserirUsuario(UsuarioBean usuario) {
         String sql = "insert into tbusuario(nomeUsu,senhaUsu,privilegio)values(?,?,?)";
         
         try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            //Inserir os valores do java no sql
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, ""+usuario.getPrivilegio());

            System.out.println(ps);
            
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
    
    public List<UsuarioBean> listarTodos() {

        String sql = "select * from tbusuario";

        //Criando um vetor ou matriz vazia para carregar os valores do bd
        List<UsuarioBean> listaUsuarios = new ArrayList<>();

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    
                    UsuarioBean ub = new UsuarioBean("","",0);
                    ub.setUsuario(rs.getString(2));
                    ub.setSenha(rs.getString(3));
                    ub.setPrivilegio(Integer.parseInt(rs.getString(4)));

                    listaUsuarios.add(ub);

                }
                return listaUsuarios;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            return null;
        }

    }
     
    
    //Criar o método update
    public String alterarUsuario(UsuarioBean usuario) {
        //Alterando os registros inseridos no bd
        String sql = "update tbusuario set nomeUsu = ?, senhaUsu = ?, privilegio = ? where nomeUsu = ?";

        try {
            String usu = usuario.getUsuario();
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, usu.substring(0, usu.indexOf("|")));
            ps.setString(2, usuario.getSenha());
            ps.setString(3, ""+usuario.getPrivilegio());
            ps.setString(4, usu.substring(usu.indexOf("|")+1, usu.length()));
            if (ps.executeUpdate() > 0) {

                return "Alterado com sucesso!!!";

            } else {
                System.out.println(ps.getWarnings());
                return "Erro ao alterar!!!";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }

    }
    
    //Criar método delete
    public String excluirUsuario(UsuarioBean usuario) {

        String sql = "delete from tbusuario where nomeUsu = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, usuario.getUsuario());

            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso!!!";
            } else {
                return "Erro ao escluir!!!";
            }

        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public boolean validarUsuario(UsuarioBean usuario){
        
       String sql = "SELECT nomeUsu, senhaUsu, privilegio FROM tbUsuario WHERE nomeUsu=? and senhaUsu=?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setPrivilegio(Integer.parseInt(rs.getString(3)));
                return true;
            }else{
                return false;
            }
            
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
}
