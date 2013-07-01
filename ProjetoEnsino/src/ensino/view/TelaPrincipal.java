package ensino.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 433);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Aulas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnNewMenu.add(mntmCadastrar);
		
		JMenuItem mntmManter_1 = new JMenuItem("Manter");
		mnNewMenu.add(mntmManter_1);
		
		JMenu mnNewMenu_1 = new JMenu("Avalia\u00E7\u00F5es");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastrar");
		mnNewMenu_1.add(mntmCadastro);
		
		JMenuItem mntmManter = new JMenuItem("Manter");
		mnNewMenu_1.add(mntmManter);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
