package ensino.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuItem mntmCadastrarAulas;
	private JMenuItem mntmManterAulas;
	private JMenuItem mntmCadastroAvaliacao;
	private JMenuItem mntmManterAvaliacao;

	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 433);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Aulas");
		menuBar.add(mnNewMenu);
		
		mntmCadastrarAulas = new JMenuItem("Cadastrar");
		mnNewMenu.add(mntmCadastrarAulas);
		mntmCadastrarAulas.addActionListener(this);
		
		mntmManterAulas = new JMenuItem("Manter");
		mnNewMenu.add(mntmManterAulas);
		mntmManterAulas.addActionListener(this);
		
		JMenu mnNewMenu_1 = new JMenu("Avalia\u00E7\u00F5es");
		menuBar.add(mnNewMenu_1);
		
		mntmCadastroAvaliacao = new JMenuItem("Cadastrar");
		mnNewMenu_1.add(mntmCadastroAvaliacao);
		mntmCadastroAvaliacao.addActionListener(this);
		
		mntmManterAvaliacao = new JMenuItem("Manter");
		mnNewMenu_1.add(mntmManterAvaliacao);
		mntmManterAvaliacao.addActionListener(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		JComponent elemento = (JComponent) e.getSource();
		if(elemento.equals(mntmCadastrarAulas)){
			TelaCadastrarAula tela = new TelaCadastrarAula();
			tela.setVisible(true);
		}
		else if(elemento.equals(mntmManterAulas)){
			TelaManterAulas tela = new TelaManterAulas();
			tela.setVisible(true);
		}
		else if(elemento.equals(mntmCadastroAvaliacao)){
			TelaCadastrarAvaliacao tela = new TelaCadastrarAvaliacao();
			tela.setVisible(true);
		}
		else if(elemento.equals(mntmManterAvaliacao)){
			TelaManterAvaliacoes tela = new TelaManterAvaliacoes();
			tela.setVisible(true);
		}
		this.dispose();
	}
}
