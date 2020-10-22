import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view extends JFrame {

	private JPanel contentPane;
	private JTextField tF_Nome;
	private JTextField tF_1Nota;
	private JTextField tF_2Nota;
	private JTextField tF_3Nota_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view frame = new view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_BoletimDNotas = new JLabel("Boletim de Notas");
		label_BoletimDNotas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_BoletimDNotas.setForeground(new Color(0, 0, 255));
		label_BoletimDNotas.setBounds(159, 0, 146, 30);
		contentPane.add(label_BoletimDNotas);
		
		JLabel label_Nome = new JLabel("Nome:");
		label_Nome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_Nome.setBounds(22, 38, 86, 21);
		contentPane.add(label_Nome);
		
		tF_Nome = new JTextField();
		tF_Nome.setBounds(88, 41, 154, 20);
		contentPane.add(tF_Nome);
		tF_Nome.setColumns(10);
		
		JLabel label_1Nota = new JLabel("1\u00B0 Nota:");
		label_1Nota.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1Nota.setBounds(22, 80, 72, 21);
		contentPane.add(label_1Nota);
		
		tF_1Nota = new JTextField();
		tF_1Nota.setBounds(88, 83, 154, 20);
		contentPane.add(tF_1Nota);
		tF_1Nota.setColumns(10);
		
		JLabel label_2Nota = new JLabel("2\u00B0 Nota:");
		label_2Nota.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2Nota.setBounds(22, 125, 72, 21);
		contentPane.add(label_2Nota);
		
		JLabel label_3Nota = new JLabel("3\u00B0 Nota:");
		label_3Nota.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_3Nota.setBounds(22, 171, 72, 21);
		contentPane.add(label_3Nota);
		
		tF_2Nota = new JTextField();
		tF_2Nota.setColumns(10);
		tF_2Nota.setBounds(88, 127, 154, 20);
		contentPane.add(tF_2Nota);
		
		tF_3Nota_1 = new JTextField();
		tF_3Nota_1.setColumns(10);
		tF_3Nota_1.setBounds(88, 172, 154, 20);
		contentPane.add(tF_3Nota_1);
		
		JLabel lblNewLabel = new JLabel("Media: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(48, 230, 342, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tF_Nome.getText();
				double nota1 =  Double.valueOf(tF_1Nota.getText());
		        double nota2 =  Double.valueOf(tF_2Nota.getText());
		        double nota3 =  Double.valueOf(tF_3Nota_1.getText());
		        double resultado = (nota1 + nota2 + nota3) / 3;
		        lblNewLabel.setText(nome + " sua média é "+ resultado);
			}
		});
		btnCalcular.setBounds(180, 203, 89, 23);
		contentPane.add(btnCalcular);
	}
}
