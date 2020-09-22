package licaolaercio;
import javax.swing.*;

public class a03e01 {
	public static void main(String args[]) {
		double maior = 0, menor = 9999999, mediaM = 0, velhoH = 0, novaM = 999999, altura;
		int idade, mulheres = 0;
		String sexo;
		String jo = "";
		
		for (int count = 1; count<=50; count++) {
			jo = JOptionPane.showInputDialog(null, "Digite a altura da "+count+"° pessoa");
			altura = Double.parseDouble(jo);
			jo = JOptionPane.showInputDialog(null, "Digite a idade da "+count+"° pessoa");
			idade = Integer.parseInt(jo);
			jo = JOptionPane.showInputDialog(null, "Digite o sexo da "+count+"° pessoa");
			sexo = jo;
			if (sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("feminino")) {
				mulheres++;
				mediaM = altura + mediaM;
				if (idade < novaM) {
					novaM = idade;
				}
			} else if (sexo.equalsIgnoreCase("m") || sexo.equalsIgnoreCase("masculino")) {
				if (idade > velhoH) {
					velhoH = idade;
				}
			}
			if (altura > maior) {
				maior = altura;
			} 
			if (altura < menor) { 
				menor = altura;
			}
		}
		JOptionPane.showMessageDialog(null, "A média de idade das mulheres é:\n"+(mediaM/mulheres)+"\n\nA maior altura é:\n"+maior+"\nA menor altura é:\n"+menor+"\n\nO homem mais velho tem "+velhoH+" anos e a mulher mais nova tem "+novaM+" Anos");
	}
}
