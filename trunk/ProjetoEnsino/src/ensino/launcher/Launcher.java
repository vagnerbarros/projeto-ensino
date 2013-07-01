package ensino.launcher;

import java.awt.EventQueue;

import ensino.view.TelaInicial;

/**
	 * Launch the application.
	 */

public class Launcher{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial telaInicial = new TelaInicial();
					telaInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}