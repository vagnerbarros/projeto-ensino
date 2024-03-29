package ensino.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ensino.dominio.Nivel;
import ensino.entidades.Aula;
import ensino.fachada.Fachada;
import ensino.util.Constantes;

public class TelaCadastrarAula extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtDescricao;
	private JFileChooser fileChooser;
	private JButton btnMaterial;
	private String material;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JComboBox<String> comboNivel;

	public TelaCadastrarAula() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 546, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 518, 372);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(30, 139, 80, 20);
		panel.add(lblDescrio);
		
		JLabel lblEndereoDoMaterial = new JLabel("Material:");
		lblEndereoDoMaterial.setBounds(30, 178, 60, 20);
		panel.add(lblEndereoDoMaterial);
		
		JLabel lblNvel = new JLabel("N\u00EDvel:");
		lblNvel.setBounds(30, 220, 53, 20);
		panel.add(lblNvel);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(250, 280, 89, 23);
		panel.add(btnCancelar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(this);
		btnCadastrar.setBounds(349, 280, 103, 23);
		panel.add(btnCadastrar);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(107, 139, 345, 20);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		btnMaterial = new JButton("Escolher");
		btnMaterial.setBounds(107, 178, 103, 20);
		btnMaterial.addActionListener(this);
		panel.add(btnMaterial);
		
		fileChooser = new JFileChooser(System.getProperty("user.home"));
		
		comboNivel = new JComboBox<String>();
		comboNivel.setBounds(107, 220, 103, 20);
		panel.add(comboNivel);
		carregarCombo();
		
		JLabel lblCadastroDeAulas = new JLabel("Cadastro de Aulas");
		lblCadastroDeAulas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCadastroDeAulas.setBounds(153, 34, 210, 43);
		panel.add(lblCadastroDeAulas);
	}
	
	private void carregarCombo(){
	
		String [] niveis = Nivel.niveis();
		for(String n : niveis){
			comboNivel.addItem(n);
		}
	}
	
	private void cadastrar(){
		
		String descricao = txtDescricao.getText();
		String nivel = comboNivel.getSelectedItem().toString();
		
		Aula aula = new Aula();
		aula.setDescricao(descricao);
		aula.setMaterial(material);
		aula.setNivel(nivel);
		
		Fachada fachada = Fachada.getInstancia();
		fachada.cadastroAula().cadastrarAula(aula);
		JOptionPane.showMessageDialog(this, "Aula Cadastrada.");
		limparCampos();
	}
	
	private void carregarMaterial(){
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.showDialog(null, "Carregar");
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		File file = fileChooser.getSelectedFile();
		if(file != null){
			String path = file.getAbsolutePath();
			String nomeArquivo = file.getName();
			File entrada = new File(path);
			File saida = new File(Constantes.CAMINHO_ARQUIVO + nomeArquivo);
			
			try {
				 FileInputStream fis = new FileInputStream(entrada);
				 FileOutputStream fos = new FileOutputStream(saida);
				 byte[] bytes = new byte[(int)entrada.length()];
				 while((fis.read(bytes)) > 0){
					 fos.write(bytes, 0, bytes.length);
				 }
				 fis.close();
				 fos.close();
				 
				 material = nomeArquivo;
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(this, "Arquivo n�o encontrado.");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Erro ao tentar carregar arquivo");
			}
		}
	}
	
	private void limparCampos(){
		
		txtDescricao.setText("");
		material = "";
		comboNivel.setSelectedIndex(0);
	}

	public void actionPerformed(ActionEvent e) {
		
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnCadastrar)){
			cadastrar();
		}
		else if(elemento.equals(btnCancelar)){
			this.dispose();
			TelaPrincipal tela = new TelaPrincipal();
			tela.setVisible(true);
		}
		else if(elemento.equals(btnMaterial)){
			carregarMaterial();
		}
	}
}
