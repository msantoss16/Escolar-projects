package licaolaercio;

public class Funcionario extends Pessoa_Fisica {
	private String registro;
	private String carteiraTrabalho;
	private String pis;
	
	public Funcionario() {
		
	}
	
	public String getRegistro() {
		return registro;
	}
	
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}
	
	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}
	
	public String getPis() {
		return pis;
	}
	
	public void getPis(String pis) {
		this.pis = pis;
	}
}
