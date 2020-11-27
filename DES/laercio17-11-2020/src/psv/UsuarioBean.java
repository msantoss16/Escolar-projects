package psv;

public class UsuarioBean {
    
    private String usuario;
    private String senha;
    private int privilegio;

    public UsuarioBean(String usuario, String senha, int privilegio) {
        this.usuario = usuario;
        this.senha = senha;
        this.privilegio = privilegio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getPrivilegio() {
        return privilegio;
    }
    
    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }
    
}
