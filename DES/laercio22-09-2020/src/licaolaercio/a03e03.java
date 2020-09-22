package licaolaercio;
import javax.swing.*;

public class a03e03 {
	public static void main(String args[]) {
		String jo = "";
		int vetor[] = new int[10]; 
		for (int count = 0; count<10; count++) {
			jo = JOptionPane.showInputDialog(null, "Digite um número ae");
			vetor[count] = Integer.parseInt(jo);
		}
		for (int count2 = 0; count2<10; count2++) {
			if (count2 % 2 == 0) {
				vetor[count2] = vetor[count2] * 2;
			} else {
				vetor[count2] = vetor[count2] * 3;
			}
			System.out.println(vetor[count2]);
		}
	}
}
