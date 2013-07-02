package ensino.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ensino.entidades.Avaliacao;
import ensino.entidades.Questao;
import ensino.entidades.Usuario;
import ensino.fachada.Fachada;
import ensino.util.GerarAvaliacao;
import ensino.util.Sessao;

public class TelaResponderAvaliacao extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Avaliacao avaliacao;
	private Usuario aluno;
	private List<Questao> questoes;
	private GerarAvaliacao gerarAvaliacao;
	private JLabel lblNomeAvaliacao;
	private JComboBox<String> combo1;
	private JComboBox<String> combo2;
	private JComboBox<String> combo3;
	private JComboBox<String> combo4;
	private JComboBox<String> combo5;
	private JButton btnEnviar;

	public TelaResponderAvaliacao(Avaliacao avaliacao, List<Questao> questoes) {
		
		this.avaliacao = avaliacao;
		this.questoes = questoes;
		aluno = Sessao.getUsuario();
		
		gerarAvaliacao = new GerarAvaliacao(avaliacao, aluno, questoes);
		gerarAvaliacao.criar();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 498, 388);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAvaliao = new JLabel("Avalia\u00E7\u00E3o");
		lblAvaliao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAvaliao.setBounds(204, 8, 107, 40);
		panel.add(lblAvaliao);
		
		lblNomeAvaliacao = new JLabel("nome avaliacao");
		lblNomeAvaliacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeAvaliacao.setBounds(10, 59, 478, 14);
		panel.add(lblNomeAvaliacao);
		
		JLabel lblGabarito = new JLabel("Gabarito:");
		lblGabarito.setBounds(30, 99, 107, 14);
		panel.add(lblGabarito);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 135, 444, 221);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblQuestao = new JLabel("Quest\u00E3o 1:");
		lblQuestao.setBounds(23, 27, 74, 14);
		panel_1.add(lblQuestao);
		
		JLabel lblQuesto = new JLabel("Quest\u00E3o 2:");
		lblQuesto.setBounds(23, 62, 74, 14);
		panel_1.add(lblQuesto);
		
		JLabel lblQuesto_1 = new JLabel("Quest\u00E3o 3:");
		lblQuesto_1.setBounds(23, 97, 74, 14);
		panel_1.add(lblQuesto_1);
		
		JLabel lblQuesto_2 = new JLabel("Quest\u00E3o 4:");
		lblQuesto_2.setBounds(23, 133, 74, 14);
		panel_1.add(lblQuesto_2);
		
		JLabel lblQuesto_3 = new JLabel("Quest\u00E3o 5:");
		lblQuesto_3.setBounds(23, 169, 74, 14);
		panel_1.add(lblQuesto_3);
		
		combo1 = new JComboBox<String>();
		combo1.setBounds(104, 24, 74, 20);
		panel_1.add(combo1);
		
		combo2 = new JComboBox<String>();
		combo2.setBounds(104, 59, 74, 20);
		panel_1.add(combo2);
		
		combo3 = new JComboBox<String>();
		combo3.setBounds(104, 94, 74, 20);
		panel_1.add(combo3);
		
		combo4 = new JComboBox<String>();
		combo4.setBounds(104, 130, 74, 20);
		panel_1.add(combo4);
		
		combo5 = new JComboBox<String>();
		combo5.setBounds(104, 166, 74, 20);
		panel_1.add(combo5);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(324, 165, 89, 23);
		panel_1.add(btnEnviar);
		btnEnviar.addActionListener(this);
		
		iniciarCombos();
	}
	
	private void iniciarCombos(){
		
		String [] letras = new String[]{"A", "B", "C", "D", "E"};
		for(String letra : letras){
			combo1.addItem(letra);
			combo2.addItem(letra);
			combo3.addItem(letra);
			combo4.addItem(letra);
			combo5.addItem(letra);
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnEnviar)){
			calcularNota();
		}
	}
	
	private void calcularNota(){
		
		List<String> gabarito = new ArrayList<String>();
		gabarito.add(combo1.getSelectedItem().toString());
		gabarito.add(combo2.getSelectedItem().toString());
		gabarito.add(combo3.getSelectedItem().toString());
		gabarito.add(combo4.getSelectedItem().toString());
		gabarito.add(combo5.getSelectedItem().toString());
		
		int contador = 0;
		for(int i = 0; i < questoes.size(); i++){
			if(questoes.get(i).getResposta().equals(gabarito.get(i))){
				contador++;
			}
		}
		
		double mediaAluno = (contador * 10) / 5;
		if(mediaAluno >= Double.parseDouble(avaliacao.getMedia())){
			JOptionPane.showMessageDialog(this, "Você foi aprovado com média " + mediaAluno);
			aluno.setNivel(aluno.getNivel() + 1);
			Sessao.setUsuario(aluno);
			Fachada.getInstancia().cadastroUsuario().editarUsuario(aluno);
		}
		else{
			JOptionPane.showMessageDialog(this, "Você foi reprovado, sua média foi " + mediaAluno + ". Você precisa de média " + avaliacao.getMedia() + " para passar.");
		}
		this.dispose();
		TelaPrincipalAluno tela = new TelaPrincipalAluno();
		tela.setVisible(true);
	}
}
