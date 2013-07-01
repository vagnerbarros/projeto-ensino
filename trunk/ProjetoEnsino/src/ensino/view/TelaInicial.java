package ensino.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import ensino.dominio.Perfil;
import ensino.entidades.Usuario;
import ensino.fachada.Fachada;

public class TelaInicial extends JFrame implements ActionListener{

	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtLoginCadastro;
	private JTextField txtEmailCadastro;
	private JTextField txtNomeCadastro;
	private JTextField txtSenhaCadastro;
	private JButton btnCadastrar;
	private JButton btnLogar;

	public TelaInicial() {
		initialize();
	}

	private void initialize() {
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 409, 412);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LJBC English");
		lblNewLabel.setBounds(93, 28, 213, 44);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		panel.add(lblNewLabel);
		
		JTextPane txtpnOProjetoTer = new JTextPane();
		txtpnOProjetoTer.setBackground(Color.WHITE);
		txtpnOProjetoTer.setEditable(false);
		txtpnOProjetoTer.setText("O projeto ter\u00E1 como objetivo ensinar a lingua estrangeira (ingl\u00EAs), atrav\u00E9s de m\u00F3dulos e n\u00EDveis, contendo um jogo de perguntas e respostas ao final de cada m\u00F3dulo, assim proporcionado uma intera\u00E7\u00E3o maior do usu\u00E1rio com o software, consequentimente visando um aprendizado mais amplo e uma satisfa\u00E7\u00E3o do proprio usu\u00E1rio");
		txtpnOProjetoTer.setBounds(22, 96, 364, 109);
		panel.add(txtpnOProjetoTer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(429, 11, 346, 147);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(29, 60, 46, 14);
		panel_1.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(29, 98, 46, 14);
		panel_1.add(lblSenha);
		
		JLabel lblAcessarOSistema = new JLabel("Acessar o Sistema");
		lblAcessarOSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAcessarOSistema.setBounds(113, 11, 150, 31);
		panel_1.add(lblAcessarOSistema);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(70, 57, 135, 20);
		panel_1.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(70, 95, 135, 20);
		panel_1.add(txtSenha);
		
		btnLogar = new JButton("Logar");
		btnLogar.setBounds(233, 53, 88, 63);
		btnLogar.addActionListener(this);
		panel_1.add(btnLogar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(429, 169, 346, 254);
		this.getContentPane().add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		
		JLabel lblQueroMeCadastrar = new JLabel("Cadastre-se");
		lblQueroMeCadastrar.setBounds(117, 21, 120, 22);
		lblQueroMeCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblQueroMeCadastrar);
		
		JLabel label = new JLabel("Login:");
		label.setBounds(26, 160, 46, 14);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Senha:");
		label_1.setBounds(26, 198, 46, 14);
		panel_2.add(label_1);
		
		txtSenhaCadastro = new JTextField();
		txtSenhaCadastro.setColumns(10);
		txtSenhaCadastro.setBounds(67, 195, 120, 20);
		panel_2.add(txtSenhaCadastro);
		
		txtLoginCadastro = new JTextField();
		txtLoginCadastro.setColumns(10);
		txtLoginCadastro.setBounds(67, 157, 120, 20);
		panel_2.add(txtLoginCadastro);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 81, 46, 14);
		panel_2.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(26, 119, 46, 14);
		panel_2.add(lblEmail);
		
		txtEmailCadastro = new JTextField();
		txtEmailCadastro.setColumns(10);
		txtEmailCadastro.setBounds(67, 116, 253, 20);
		panel_2.add(txtEmailCadastro);
		
		txtNomeCadastro = new JTextField();
		txtNomeCadastro.setColumns(10);
		txtNomeCadastro.setBounds(67, 78, 253, 20);
		panel_2.add(txtNomeCadastro);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(214, 153, 106, 59);
		btnCadastrar.addActionListener(this);
		panel_2.add(btnCadastrar);
	}

	public void actionPerformed(ActionEvent e) {
		
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnCadastrar)){
			cadastrar();
		}
		else if(elemento.equals(btnLogar)){
			logar();
		}
	}
	
	private void cadastrar(){
		
		String nome = txtNomeCadastro.getText();
		String email = txtEmailCadastro.getText();
		String login = txtLoginCadastro.getText();
		String senha = txtSenhaCadastro.getText();
		
		Usuario novo = new Usuario();
		novo.setNome(nome);
		novo.setEmail(email);
		novo.setLogin(login);
		novo.setSenha(senha);
		
		Fachada fachada = Fachada.getInstancia();
		fachada.cadastroUsuario().cadastrarAluno(novo);
		JOptionPane.showMessageDialog(this, "Aluno Cadastrado com sucesso!");
		limparCadastro();
	}
	
	private void logar(){
		
		String login = txtLogin.getText();
		String senha = txtSenha.getText();
		
		Fachada fachada = Fachada.getInstancia();
		Usuario log = fachada.cadastroUsuario().logar(login, senha);
		if(log == null){
			JOptionPane.showMessageDialog(this, "Login/Senha Incorretos.");
		}
		else{
			JOptionPane.showMessageDialog(this, "Bem Vindo, " + log.getNome());
			//chamar a tela dependendo do perfil.
			if(log.getPerfil().equals(Perfil.ALUNO)){
				TelaPrincipalAluno tela = new TelaPrincipalAluno();
				tela.setVisible(true);
			}
			else if(log.getPerfil().equals(Perfil.PROFESSOR)){
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
			}
			this.dispose();
		}
	}
	
	private void limparCadastro(){
		
		txtNomeCadastro.setText("");
		txtEmailCadastro.setText("");
		txtLoginCadastro.setText("");
		txtSenhaCadastro.setText("");
	}
}
