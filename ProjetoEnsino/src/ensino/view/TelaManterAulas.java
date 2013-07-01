package ensino.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class TelaManterAulas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaManterAulas frame = new TelaManterAulas();
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
	public TelaManterAulas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 630, 389);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblListagemDeAulas = new JLabel("Manter de Aulas");
		lblListagemDeAulas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblListagemDeAulas.setBounds(196, 11, 190, 50);
		panel.add(lblListagemDeAulas);
		
		JLabel lblNvel = new JLabel("N\u00EDvel:");
		lblNvel.setBounds(35, 93, 46, 14);
		panel.add(lblNvel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(74, 90, 80, 20);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 138, 555, 187);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(303, 336, 89, 23);
		panel.add(btnVisualizar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(402, 336, 89, 23);
		panel.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(501, 336, 89, 23);
		panel.add(btnEditar);
	}
}
