package licaolaercio;
import javax.swing.*;

public class a03e04 {
	public static void main(String args[]) {
		String jo = "";
		int vetor[] = new int[10], media = 0; 
		for (int count = 0; count<10; count++) {
			jo = JOptionPane.showInputDialog(null, "Digite um número ae");
			vetor[count] = Integer.parseInt(jo);
			media = media + vetor[count];
		}
		System.out.println(media/10);
	}
}