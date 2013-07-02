package ensino.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ensino.dominio.Nivel;
import ensino.entidades.Avaliacao;
import ensino.fachada.Fachada;
import ensino.util.Tabela;

public class TelaManterAvaliacoes extends JFrame implements ActionListener, ItemListener{

	private JPanel contentPane;
	private Tabela<Avaliacao> tabela;
	private JComboBox<String> comboNivel;
	private JButton btnVisualizar;
	private JButton btnRemover;
	private JButton btnEditar;

	public TelaManterAvaliacoes() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lblListagemDeAulas = new JLabel("Manter de Avalia\u00E7\u00F5es");
		lblListagemDeAulas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblListagemDeAulas.setBounds(196, 11, 263, 50);
		panel.add(lblListagemDeAulas);
		
		JLabel lblNvel = new JLabel("N\u00EDvel:");
		lblNvel.setBounds(35, 93, 46, 14);
		panel.add(lblNvel);
		
		comboNivel = new JComboBox<String>();
		comboNivel.setBounds(74, 90, 80, 20);
		carregarCombo();
		panel.add(comboNivel);
		comboNivel.addItemListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 138, 555, 187);
		panel.add(scrollPane);
		
		tabela = new Tabela<Avaliacao>(new String [] {"Nome", "Média", "Nível"});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
		tabela.montarTabela(Fachada.getInstancia().cadastroAvaliacao().listarAvaliacao());
		scrollPane.setViewportView(tabela);
		
		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(303, 336, 89, 23);
		btnVisualizar.addActionListener(this);
		panel.add(btnVisualizar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(402, 336, 89, 23);
		btnRemover.addActionListener(this);
		panel.add(btnRemover);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(501, 336, 89, 23);
		btnEditar.addActionListener(this);
		panel.add(btnEditar);
	}
	
	private void carregarCombo(){
		String [] niveis = Nivel.niveis();
		for(String n : niveis){
			comboNivel.addItem(n);
		}
	}
	
	private void remover(){
		
		int linha = tabela.getSelectedRow();
		if(linha != -1){
			Object[] options = { "OK", "Cancelar" };
			int resposta = JOptionPane.showOptionDialog(this, "Tem certeza que deseja remover?", "Alerta !!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(resposta == 0){
				Avaliacao avaliacao = (Avaliacao) tabela.getModel().getValueAt(linha, 0);
				Fachada fachada = Fachada.getInstancia();
				fachada.cadastroAvaliacao().removerAvaliacao(avaliacao);
				tabela.montarTabela(Fachada.getInstancia().cadastroAvaliacao().listarAvaliacao());
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnEditar)){
			
		}
		else if(elemento.equals(btnRemover)){
			remover();
		}
		else if(elemento.equals(btnVisualizar)){
			
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		int evento = e.getStateChange();
		if(evento == ItemEvent.SELECTED){
			String nivel = comboNivel.getSelectedItem().toString();
			Fachada fachada = Fachada.getInstancia();
			List<Avaliacao> lista = fachada.cadastroAvaliacao().buscarNivel(nivel);
			tabela.montarTabela(lista);
		}
	}
}
