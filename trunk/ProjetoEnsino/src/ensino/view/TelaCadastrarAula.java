package ensino.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

public class TelaCadastrarAula extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public TelaCadastrarAula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 518, 372);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(50, 139, 60, 20);
		panel.add(lblDescrio);
		
		JLabel lblEndereoDoMaterial = new JLabel("Material:");
		lblEndereoDoMaterial.setBounds(50, 178, 60, 20);
		panel.add(lblEndereoDoMaterial);
		
		JLabel lblNvel = new JLabel("N\u00EDvel:");
		lblNvel.setBounds(50, 220, 53, 20);
		panel.add(lblNvel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(250, 280, 89, 23);
		panel.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(349, 280, 89, 23);
		panel.add(btnCadastrar);
		
		textField = new JTextField();
		textField.setBounds(107, 139, 345, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 178, 345, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(107, 220, 81, 20);
		panel.add(comboBox);
		
		JLabel lblCadastroDeAulas = new JLabel("Cadastro de Aulas");
		lblCadastroDeAulas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCadastroDeAulas.setBounds(153, 34, 210, 43);
		panel.add(lblCadastroDeAulas);
	}
}
