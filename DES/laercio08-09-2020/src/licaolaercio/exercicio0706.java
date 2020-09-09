package licaolaercio;

import javax.swing.*;

public class exercicio0706 {
	public static void main(String args[]) {
		double salario;
		String jo = "";
		jo = JOptionPane.showInputDialog(null, "Insira o salário: ");
		salario = Double.parseDouble(jo);
		if (salario >= 465) {
			if (salario <= 965.67) {
				JOptionPane.showMessageDialog(null, "A Alíquota é: 8,0\nO Salario é: "+(salario*0.92));
			}
			else if(salario <= 1609.45){
				JOptionPane.showMessageDialog(null, "A Alíquota é: 9,0\nO salario é: "+(salario*0.91));
			}
			else if(salario <= 3218.90) {
				JOptionPane.showMessageDialog(null, "A Alíquota é: 11,0\nO salario é: "+(salario*0.89));
			} else {
				JOptionPane.showMessageDialog(null, "Valor invalido!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Valor invalido!");
		}
	}
}
