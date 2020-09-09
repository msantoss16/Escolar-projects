package licaolaercio;

import javax.swing.*;

public class exercicio0707 {
	public static void main(String args[]) {
		double peso, altura, imc;
		String jo = "";
		jo = JOptionPane.showInputDialog(null, "Digite aqui seu peso em Kilogramas (Kg): ");
		peso = Double.parseDouble(jo);
		jo = JOptionPane.showInputDialog(null, "Digite aqui sua altura em metros (m): ");
		altura = Double.parseDouble(jo);
		if (peso > 0.5 && altura > 0.1) {
			imc = peso / (Math.pow(altura, 2));
			JOptionPane.showMessageDialog(null, (imc < 18.5) ? "Excesso de magreza" : (imc < 25) ? "Peso Normal" : (imc < 30) ? "Excesso de peso" : (imc < 35) ? "Obesidade (Grau I)" : (imc < 40) ? "Obesidade (Grau II)" : "Obesidade (Grau III)");
		} else {
			JOptionPane.showMessageDialog(null, "error");
		}
	}
}
