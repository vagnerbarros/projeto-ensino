package ensino.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaCadastrarAvaliacao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarAvaliacao frame = new TelaCadastrarAvaliacao();
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
	public TelaCadastrarAvaliacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 676, 389);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(28, 70, 46, 14);
		panel.add(lblNome);
		
		JLabel lblCadastrarAvaliao = new JLabel("Cadastrar Avalia\u00E7\u00E3o");
		lblCadastrarAvaliao.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCadastrarAvaliao.setBounds(218, 0, 237, 46);
		panel.add(lblCadastrarAvaliao);
		
		textField = new JTextField();
		textField.setBounds(68, 67, 582, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblMdia = new JLabel("M\u00E9dia:");
		lblMdia.setBounds(28, 108, 46, 14);
		panel.add(lblMdia);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 105, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNvel = new JLabel("N\u00EDvel:");
		lblNvel.setBounds(176, 108, 46, 14);
		panel.add(lblNvel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(216, 105, 86, 20);
		panel.add(comboBox);
		
		JLabel lblQuestes = new JLabel("Quest\u00F5es");
		lblQuestes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuestes.setBounds(278, 143, 99, 25);
		panel.add(lblQuestes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 179, 582, 154);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(622, 180, 41, 31);
		panel.add(btnNewButton);
		
		JButton button = new JButton("-");
		button.setBounds(622, 222, 41, 31);
		panel.add(button);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(523, 355, 89, 23);
		panel.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(424, 355, 89, 23);
		panel.add(btnCancelar);
	}

}
