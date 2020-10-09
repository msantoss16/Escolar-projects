package licaolaercio;

public class Pessoa_Fisica {
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private int dataNascimento;
	private int clienteDesde;
	
	public Pessoa_Fisica() {
		
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getNascimento() {
		return dataNascimento;
	}
	
	public void setNascimento(int dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getClienteDesde() {
		return clienteDesde;
	}
	
	public void setClienteDesde(int clienteDesde) {
		this.clienteDesde = clienteDesde;
	}
}
