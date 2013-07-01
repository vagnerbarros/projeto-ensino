package ensino.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class TelaAssistirAulas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public TelaAssistirAulas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 564, 317);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAulasDisponveisPara = new JLabel("Aulas dispon\u00EDveis para o n\u00EDvel ");
		lblAulasDisponveisPara.setBounds(24, 41, 163, 24);
		panel.add(lblAulasDisponveisPara);
		
		JLabel lblNivel = new JLabel("1");
		lblNivel.setBounds(173, 46, 39, 14);
		panel.add(lblNivel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 122, 516, 140);
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
		
		JButton btnAssistir = new JButton("Assistir");
		btnAssistir.setBounds(451, 273, 89, 23);
		panel.add(btnAssistir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(352, 273, 89, 23);
		panel.add(btnVoltar);
	}

}
