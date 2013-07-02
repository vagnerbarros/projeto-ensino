package ensino.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ensino.entidades.Avaliacao;
import ensino.entidades.Questao;
import ensino.entidades.Usuario;
import ensino.fachada.Fachada;
import ensino.util.Sessao;

public class TelaPrincipalAluno extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblNivel;
	private JLabel lblNomeAluno;
	private JButton btnAulas;
	private JButton btnAvaliao;

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
		
		Usuario aluno = Sessao.getUsuario();
		lblNomeAluno = new JLabel(aluno.getNome());
		lblNomeAluno.setBounds(67, 40, 353, 14);
		panel.add(lblNomeAluno);
		
		JLabel lblVocEstNo = new JLabel("Voc\u00EA est\u00E1 no n\u00EDvel:");
		lblVocEstNo.setBounds(25, 65, 114, 14);
		panel.add(lblVocEstNo);
		
		lblNivel = new JLabel(aluno.getNivel() + "");
		lblNivel.setBounds(142, 65, 31, 14);
		panel.add(lblNivel);
		
		JLabel lblOQueDeseja = new JLabel("O que deseja fazer agora?");
		lblOQueDeseja.setBounds(188, 115, 153, 14);
		panel.add(lblOQueDeseja);
		
		JLabel lblAssistirAulas = new JLabel("Assistir Aulas:");
		lblAssistirAulas.setBounds(140, 156, 138, 14);
		panel.add(lblAssistirAulas);
		
		JLabel lblFazerAvaliao = new JLabel("Fazer Avalia\u00E7\u00E3o:");
		lblFazerAvaliao.setBounds(140, 199, 138, 14);
		panel.add(lblFazerAvaliao);
		
		btnAulas = new JButton("Aulas");
		btnAulas.setBounds(267, 152, 108, 23);
		btnAulas.addActionListener(this);
		panel.add(btnAulas);
		
		btnAvaliao = new JButton("Avalia\u00E7\u00E3o");
		btnAvaliao.setBounds(267, 195, 108, 23);
		btnAvaliao.addActionListener(this);
		panel.add(btnAvaliao);
	}

	public void actionPerformed(ActionEvent e) {
		
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnAulas)){
			TelaAssistirAulas tela = new TelaAssistirAulas();
			tela.setVisible(true);
		}
		else if(elemento.equals(btnAvaliao)){
			Usuario aluno = Sessao.getUsuario();
			List<Avaliacao> temp = Fachada.getInstancia().cadastroAvaliacao().buscarNivel(aluno.getNivel() + "");
			
			if(!temp.isEmpty()){
				Avaliacao avaliacao = temp.get(0);
				List<Questao> questoes = Fachada.getInstancia().cadastroQuestao().buscarPorAvaliacao(avaliacao.getId());
				TelaResponderAvaliacao tela = new TelaResponderAvaliacao(avaliacao, questoes);
				tela.setVisible(true);
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this, "Não existe nenhuma avaliação cadastrada para seu nível.");
			}
		}
	}
}
