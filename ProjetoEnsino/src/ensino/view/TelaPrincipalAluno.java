package ensino.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaPrincipalAluno extends JFrame {

	private JPanel contentPane;

	public TelaPrincipalAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 517, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOl = new JLabel("Ol\u00E1, ");
		lblOl.setBounds(25, 40, 39, 14);
		panel.add(lblOl);
		
		JLabel lblNomeAluno = new JLabel("Vagner");
		lblNomeAluno.setBounds(52, 40, 46, 14);
		panel.add(lblNomeAluno);
		
		JLabel lblVocEstNo = new JLabel("Voc\u00EA est\u00E1 no n\u00EDvel ");
		lblVocEstNo.setBounds(25, 65, 102, 14);
		panel.add(lblVocEstNo);
		
		JLabel lblNivel = new JLabel("1");
		lblNivel.setBounds(121, 65, 46, 14);
		panel.add(lblNivel);
		
		JLabel lblOQueDeseja = new JLabel("O que deseja fazer agora?");
		lblOQueDeseja.setBounds(188, 115, 153, 14);
		panel.add(lblOQueDeseja);
		
		JLabel lblAssistirAulas = new JLabel("Assistir Aulas:");
		lblAssistirAulas.setBounds(140, 156, 79, 14);
		panel.add(lblAssistirAulas);
		
		JLabel lblFazerAvaliao = new JLabel("Fazer Avalia\u00E7\u00E3o:");
		lblFazerAvaliao.setBounds(140, 199, 102, 14);
		panel.add(lblFazerAvaliao);
		
		JButton btnNewButton = new JButton("Aulas");
		btnNewButton.setBounds(236, 152, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnAvaliao = new JButton("Avalia\u00E7\u00E3o");
		btnAvaliao.setBounds(236, 195, 87, 23);
		panel.add(btnAvaliao);
	}

}
