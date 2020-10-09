package licaolaercio;

public class testarclasses {
	public static void main(String[] args) {
		Funcionario fu = new Funcionario();
		
		fu.setNome("Josias dos Santos");
		fu.setCpf("272.011.758-74");
		fu.setNascimento(11011980);
		fu.setClienteDesde(21102019);
		fu.setEmail("josias.pro@gmail.com");
		fu.setTelefone("59277228");
		fu.setRegistro("6877777777");
		fu.setCarteiraTrabalho("55555555555555555555555");
		fu.getPis("53245234");
		
		System.out.printf("Funcionario\nNome: %s \nCpf: %s\nData de nascimento: %s\nCliente desde: %s\nEmail: %s\nTelefone: %s\nRegistro: %s\nCarteira de Trabalho: %s\nPis: %s", fu.getNome(), fu.getCpf(), fu.getNascimento(), fu.getClienteDesde(), fu.getEmail(), fu.getEmail(), fu.getRegistro(), fu.getCarteiraTrabalho(), fu.getPis());
	}
}
