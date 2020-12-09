/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

/**
 *
 * @author Matheus
 */
public class ClienteBean {
    private String nome;
    private String telResidencial;
    private String telComercial;
    private String telCelular;
    private String email;
    private int id;
    
    public ClienteBean(){
    
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTelRes(){
        return telResidencial;
    }
    
    public void setTelRes(String telResidencial) {
        this.telResidencial = telResidencial;
    }
    
    public String getTelCom(){
        return telComercial;
    }
    
    public void setTelCom(String telComercial) {
        this.telComercial = telComercial;
    }
    
    public String getTelCel(){
        return telCelular;
    }
    
    public void setTelCel(String telCelular) {
        this.telCelular = telCelular;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
