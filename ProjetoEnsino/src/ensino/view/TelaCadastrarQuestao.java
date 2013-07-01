package ensino.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Label;
import javax.swing.JButton;

public class TelaCadastrarQuestao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarQuestao frame = new TelaCadastrarQuestao();
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
	public TelaCadastrarQuestao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 578, 388);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblQuesto = new JLabel("Quest\u00E3o");
		lblQuesto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblQuesto.setBounds(234, 11, 113, 40);
		panel.add(lblQuesto);
		
		JLabel lblPergunta = new JLabel("Pergunta:");
		lblPergunta.setBounds(32, 81, 60, 14);
		panel.add(lblPergunta);
		
		textField = new JTextField();
		textField.setBounds(91, 78, 414, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblAlternativas = new JLabel("Alternativas");
		lblAlternativas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlternativas.setBounds(234, 124, 124, 35);
		panel.add(lblAlternativas);
		
		JLabel lblA = new JLabel("A)");
		lblA.setBounds(63, 186, 29, 14);
		panel.add(lblA);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 183, 414, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblB = new JLabel("B)");
		lblB.setBounds(63, 217, 29, 14);
		panel.add(lblB);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 214, 414, 20);
		panel.add(textField_2);
		
		JLabel lblC = new JLabel("C)");
		lblC.setBounds(63, 245, 29, 14);
		panel.add(lblC);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(91, 242, 414, 20);
		panel.add(textField_3);
		
		JLabel lblD = new JLabel("D)");
		lblD.setBounds(63, 274, 29, 14);
		panel.add(lblD);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(91, 271, 414, 20);
		panel.add(textField_4);
		
		JLabel lblE = new JLabel("E)");
		lblE.setBounds(63, 302, 29, 14);
		panel.add(lblE);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(91, 299, 414, 20);
		panel.add(textField_5);
		
		JRadioButton rdbtnX = new JRadioButton("");
		rdbtnX.setBounds(511, 182, 21, 23);
		panel.add(rdbtnX);
		
		Label label = new Label("Correta");
		label.setBounds(503, 151, 44, 22);
		panel.add(label);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(511, 213, 21, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(511, 241, 21, 23);
		panel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(511, 270, 21, 23);
		panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(511, 298, 21, 23);
		panel.add(radioButton_3);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(416, 343, 89, 23);
		panel.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(317, 343, 89, 23);
		panel.add(btnCancelar);
	}
}
