package licaolaercio;
import javax.swing.*;

public class a03e02 {
	public static void main(String args[]) {
		int idade, pS = 0, mulheres = 0, pC = 0;
		double pSS;
		String jo = "", sexo, cCabelo;
		for (int count = 1; count<=3; count++) {
			sexo = JOptionPane.showInputDialog(null, "Digite o sexo da "+count+"° pessoa");
			jo = JOptionPane.showInputDialog(null, "Digite a idade da "+count+"° pessoa");
			idade = Integer.parseInt(jo);
			cCabelo = JOptionPane.showInputDialog(null, "Qual a cor de cabelo da "+count+"° pessoa?");
			if (sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("feminino")) {
				mulheres++;
			}
			if (idade > 30) {
				pS++;
			}
			if (cCabelo.equals("castanho")) {
				pC++;
			}
		}
		pSS = (100 * pS/300);
		JOptionPane.showMessageDialog(null, "O número de mulheres é: "+mulheres+"\n\nA porcentagem de habitantes com idade superior a 30 é: "+pSS+"\n\nHá "+pC+" pessoas de cabelo castanho");
	}
}
