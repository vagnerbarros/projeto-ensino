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
import ensino.entidades.Aula;
import ensino.fachada.Fachada;
import ensino.util.Tabela;

public class TelaManterAulas extends JFrame implements ItemListener, ActionListener{

	private JPanel contentPane;
	private Tabela<Aula> tabela;
	private JComboBox<String> comboNivel;
	private JButton btnVisualizar;
	private JButton btnRemover;
	private JButton btnEditar;

	public TelaManterAulas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblListagemDeAulas = new JLabel("Manter de Aulas");
		lblListagemDeAulas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblListagemDeAulas.setBounds(196, 11, 190, 50);
		panel.add(lblListagemDeAulas);
		
		JLabel lblNvel = new JLabel("N\u00EDvel:");
		lblNvel.setBounds(35, 93, 46, 14);
		panel.add(lblNvel);
		
		comboNivel = new JComboBox<String>();
		comboNivel.setBounds(74, 90, 80, 20);
		panel.add(comboNivel);
		carregarCombo();
		comboNivel.addItemListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 138, 555, 187);
		panel.add(scrollPane);
		
		tabela = new Tabela(new String [] {"Descrição", "Nível", "Material"});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(300);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(300);
		tabela.montarTabela(Fachada.getInstancia().cadastroAula().listarAulas());
		scrollPane.setViewportView(tabela);
		
		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(294, 336, 98, 23);
		panel.add(btnVisualizar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(this);
		btnRemover.setBounds(402, 336, 89, 23);
		panel.add(btnRemover);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(501, 336, 89, 23);
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
				Aula aula = (Aula) tabela.getModel().getValueAt(linha, 0);
				Fachada fachada = Fachada.getInstancia();
				fachada.cadastroAula().removerAula(aula);
				tabela.montarTabela(Fachada.getInstancia().cadastroAula().listarAulas());
			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		int evento = e.getStateChange();
		if(evento == ItemEvent.SELECTED){
			String nivel = comboNivel.getSelectedItem().toString();
			Fachada fachada = Fachada.getInstancia();
			List<Aula> lista = fachada.cadastroAula().buscarNivel(nivel);
			tabela.montarTabela(lista);
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
}
