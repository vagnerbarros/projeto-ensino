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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ensino.dominio.Nivel;
import ensino.entidades.Avaliacao;
import ensino.entidades.Questao;
import ensino.fachada.Fachada;
import ensino.util.Tabela;

public class TelaCadastrarAvaliacao extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtMedia;
	private Tabela<Questao> tabela;
	private JComboBox<String> comboNivel;
	private JButton btnAdicionar;
	private JButton btnRetirar;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private List<Questao> questoes;

	public TelaCadastrarAvaliacao() {
		
		questoes = new ArrayList<Questao>();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		txtNome = new JTextField();
		txtNome.setBounds(68, 67, 544, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblMdia = new JLabel("M\u00E9dia:");
		lblMdia.setBounds(28, 108, 46, 14);
		panel.add(lblMdia);
		
		txtMedia = new JTextField();
		txtMedia.setBounds(68, 105, 86, 20);
		panel.add(txtMedia);
		txtMedia.setColumns(10);
		
		JLabel lblNvel = new JLabel("N\u00EDvel:");
		lblNvel.setBounds(176, 108, 46, 14);
		panel.add(lblNvel);
		
		comboNivel = new JComboBox<String>();
		comboNivel.setBounds(216, 105, 86, 20);
		panel.add(comboNivel);
		carregarCombo();
		
		JLabel lblQuestes = new JLabel("Quest\u00F5es");
		lblQuestes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuestes.setBounds(278, 143, 99, 25);
		panel.add(lblQuestes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 179, 582, 154);
		panel.add(scrollPane);
		
		tabela = new Tabela<Questao>(new String [] {"Pergunta"});
		tabela.montarTabela(questoes);
		scrollPane.setViewportView(tabela);
		
		btnAdicionar = new JButton("+");
		btnAdicionar.setBounds(622, 180, 41, 31);
		panel.add(btnAdicionar);
		btnAdicionar.addActionListener(this);
		
		btnRetirar = new JButton("-");
		btnRetirar.setBounds(622, 222, 41, 31);
		panel.add(btnRetirar);
		btnRetirar.addActionListener(this);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(509, 355, 103, 23);
		panel.add(btnCadastrar);
		btnCadastrar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(410, 355, 89, 23);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(this);
	}
	
	private void carregarCombo(){
		String [] niveis = Nivel.niveis();
		for(String n : niveis){
			comboNivel.addItem(n);
		}
	}
	
	public void adicionarQuestao(Questao q){
		questoes.add(q);
		tabela.montarTabela(questoes);
	}
	
	private void cadastrar(){
		
		String nome = txtNome.getText();
		String media = txtMedia.getText();
		String nivel = comboNivel.getSelectedItem().toString();
		
		Fachada fachada = Fachada.getInstancia();
		int nextId = fachada.cadastroAvaliacao().proximoIdAvaliacao();
		
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setId(nextId);
		avaliacao.setMedia(media);
		avaliacao.setNivel(nivel);
		avaliacao.setNome(nome);
		fachada.cadastroAvaliacao().cadastrarAvaliacao(avaliacao);
		
		for(Questao q : questoes){
			q.setId_avaliacao(nextId);
			fachada.cadastroQuestao().cadastrarQuestao(q);
		}
		
		JOptionPane.showMessageDialog(this, "Avaliação cadastrada com sucesso.");
		limparCampos();
		tabela.montarTabela(questoes);
	}
	
	private void limparCampos(){
		txtNome.setText("");
		txtMedia.setText("");
		comboNivel.setSelectedIndex(0);
		questoes = new ArrayList<Questao>();
	}
	
	private void remover(){
		
		int linha = tabela.getSelectedRow();
		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(this, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Questao q = (Questao) tabela.getModel().getValueAt(linha, 0);
				questoes.remove(q);
				tabela.montarTabela(questoes);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnAdicionar)){
			TelaCadastrarQuestao tela = new TelaCadastrarQuestao(this);
			tela.setVisible(true);
		}
		else if(elemento.equals(btnRetirar)){
			remover();
		}
		else if(elemento.equals(btnCadastrar)){
			cadastrar();
		}
		else if(elemento.equals(btnCancelar)){
			this.dispose();
		}
	}
}
