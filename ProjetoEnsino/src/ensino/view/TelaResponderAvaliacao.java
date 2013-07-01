package ensino.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaResponderAvaliacao extends JFrame {

	private JPanel contentPane;

	public TelaResponderAvaliacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 719, 388);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAvaliao = new JLabel("Avalia\u00E7\u00E3o");
		lblAvaliao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAvaliao.setBounds(317, 11, 107, 40);
		panel.add(lblAvaliao);
		
		JLabel lblNomeAvaliacao = new JLabel("nome avaliacao");
		lblNomeAvaliacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeAvaliacao.setBounds(10, 48, 699, 14);
		panel.add(lblNomeAvaliacao);
	}

}
