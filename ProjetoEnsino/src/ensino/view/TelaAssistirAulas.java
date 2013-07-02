package ensino.view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ensino.entidades.Aula;
import ensino.entidades.Usuario;
import ensino.fachada.Fachada;
import ensino.util.Constantes;
import ensino.util.Sessao;
import ensino.util.Tabela;

public class TelaAssistirAulas extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Tabela<Aula> tabela;
	private JButton btnVoltar;
	private JButton btnAssistir;
	private JLabel lblNivel;
	private Usuario aluno;

	public TelaAssistirAulas() {
		aluno = Sessao.getUsuario();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 592, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 564, 317);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblAulasDisponveisPara = new JLabel("Aulas dispon\u00EDveis para o n\u00EDvel:");
		lblAulasDisponveisPara.setBounds(24, 44, 178, 19);
		panel.add(lblAulasDisponveisPara);

		lblNivel = new JLabel(aluno.getNivel() + "");
		lblNivel.setBounds(207, 46, 39, 14);
		panel.add(lblNivel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 122, 516, 140);
		panel.add(scrollPane);

		tabela = new Tabela<Aula>(new String [] {"Descrição", "Nível"});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(400);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabela.montarTabela(Fachada.getInstancia().cadastroAula().buscarNivel(aluno.getNivel() + ""));
		scrollPane.setViewportView(tabela);

		btnAssistir = new JButton("Assistir");
		btnAssistir.setBounds(451, 273, 89, 23);
		btnAssistir.addActionListener(this);
		panel.add(btnAssistir);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(352, 273, 89, 23);
		btnVoltar.addActionListener(this);
		panel.add(btnVoltar);
	}

	private void assistirAula(){

		int linha = tabela.getSelectedRow();
		if(linha != -1){
			Aula aula = (Aula) tabela.getModel().getValueAt(linha, 0);
			File video = new File(Constantes.CAMINHO_ARQUIVO + aula.getMaterial());
			try {
				Desktop.getDesktop().open(video);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(btnAssistir)){
			assistirAula();
		}
		else if(elemento.equals(btnVoltar)){
			this.dispose();
		}
	}
}
