package ensino.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ensino.entidades.Questao;

public class TelaCadastrarQuestao extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtPergunta;
	private JTextField alternativaA;
	private JTextField alternativaB;
	private JTextField alternativaC;
	private JTextField alternativaD;
	private JTextField alternativaE;
	private TelaCadastrarAvaliacao telaAvaliacao;
	private JRadioButton rbE;
	private JRadioButton rbD;
	private JRadioButton rbC;
	private JRadioButton rbB;
	private JRadioButton rbA;
	private ButtonGroup grupo;
	private JButton btnCadastrar;
	private JButton btnCancelar;

	public TelaCadastrarQuestao(TelaCadastrarAvaliacao telaAvaliacao) {
		
		this.telaAvaliacao = telaAvaliacao;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		txtPergunta = new JTextField();
		txtPergunta.setBounds(91, 78, 414, 20);
		panel.add(txtPergunta);
		txtPergunta.setColumns(10);
		
		JLabel lblAlternativas = new JLabel("Alternativas");
		lblAlternativas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlternativas.setBounds(234, 124, 124, 35);
		panel.add(lblAlternativas);
		
		JLabel lblA = new JLabel("A)");
		lblA.setBounds(63, 186, 29, 14);
		panel.add(lblA);
		
		alternativaA = new JTextField();
		alternativaA.setBounds(91, 183, 414, 20);
		panel.add(alternativaA);
		alternativaA.setColumns(10);
		
		JLabel lblB = new JLabel("B)");
		lblB.setBounds(63, 217, 29, 14);
		panel.add(lblB);
		
		alternativaB = new JTextField();
		alternativaB.setColumns(10);
		alternativaB.setBounds(91, 214, 414, 20);
		panel.add(alternativaB);
		
		JLabel lblC = new JLabel("C)");
		lblC.setBounds(63, 245, 29, 14);
		panel.add(lblC);
		
		alternativaC = new JTextField();
		alternativaC.setColumns(10);
		alternativaC.setBounds(91, 242, 414, 20);
		panel.add(alternativaC);
		
		JLabel lblD = new JLabel("D)");
		lblD.setBounds(63, 274, 29, 14);
		panel.add(lblD);
		
		alternativaD = new JTextField();
		alternativaD.setColumns(10);
		alternativaD.setBounds(91, 271, 414, 20);
		panel.add(alternativaD);
		
		JLabel lblE = new JLabel("E)");
		lblE.setBounds(63, 302, 29, 14);
		panel.add(lblE);
		
		alternativaE = new JTextField();
		alternativaE.setColumns(10);
		alternativaE.setBounds(91, 299, 414, 20);
		panel.add(alternativaE);
		
		grupo = new ButtonGroup();
		
		rbA = new JRadioButton("");
		rbA.setActionCommand("A");
		grupo.add(rbA);
		rbA.setBounds(511, 182, 21, 23);
		panel.add(rbA);
		
		Label label = new Label("Correta");
		label.setBounds(503, 151, 44, 22);
		panel.add(label);
		
		rbB = new JRadioButton("");
		rbB.setActionCommand("B");
		grupo.add(rbB);
		rbB.setBounds(511, 213, 21, 23);
		panel.add(rbB);
		
		rbC = new JRadioButton("");
		rbC.setActionCommand("C");
		grupo.add(rbC);
		rbC.setBounds(511, 241, 21, 23);
		panel.add(rbC);
		
		rbD = new JRadioButton("");
		rbD.setActionCommand("D");
		grupo.add(rbD);
		rbD.setBounds(511, 270, 21, 23);
		panel.add(rbD);
		
		rbE = new JRadioButton("");
		rbE.setActionCommand("E");
		grupo.add(rbE);
		rbE.setBounds(511, 298, 21, 23);
		panel.add(rbE);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(408, 343, 97, 23);
		panel.add(btnCadastrar);
		btnCadastrar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(309, 343, 89, 23);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(this);
	}
	
	private void cadastrar(){
		
		String pergunta = txtPergunta.getText();
		String [] alternativas = new String [] {alternativaA.getText(), alternativaB.getText(), alternativaC.getText(), alternativaD.getText(), alternativaE.getText()};
		String resposta = grupo.getSelection().getActionCommand();
		
		Questao questao = new Questao();
		questao.setPergunta(pergunta);
		questao.setAlternativa(alternativas);
		questao.setResposta(resposta);
		
		telaAvaliacao.adicionarQuestao(questao);
		this.dispose();
	}
	
	private void cancelar(){
		this.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnCadastrar)){
			cadastrar();
		}
		else if(elemento.equals(btnCancelar)){
			cancelar();
		}
	}
}
