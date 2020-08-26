package licaolaercio;

/*Utilizando métodos com JOptionPane
Criar um método em java que multiplique dois valores 
digitados pelo usuário através do JOptionPane e devolva o 
resultado da multiplicação em uma Janela JOptionPane.*/

import javax.swing.*;

public class jopitionpane {
	public static void main(String args[]) {
		double n1, n2, resp = 0;
		String jo = "";
		
		jo = JOptionPane.showInputDialog(null, "Insira o primeiro número");
		n1 = Double.parseDouble(jo);
		
		jo = JOptionPane.showInputDialog(null, "Insira o segundo número");
		
		n2 = Double.parseDouble(jo);
		
		resp = n1*n2;
		
		JOptionPane.showMessageDialog(null, "A multiplicação é "+resp);
	}
}
