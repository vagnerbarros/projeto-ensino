
package ensino.fachada;

import ensino.cadastros.CadastroUsuario;
import ensino.interfaces.IRepositorioUsuario;
import ensino.repositorios.RepositorioUsuario;

public class Fachada {

	private static Fachada instancia;
	private CadastroUsuario cadUsuario;

	private Fachada(){
		iniciarContoladores();
	}

	public static Fachada getInstancia(){
		if (instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	}

	private void iniciarContoladores(){
		
		IRepositorioUsuario repAluno = new RepositorioUsuario();
		cadUsuario = new CadastroUsuario(repAluno);
	}

	public CadastroUsuario cadastroUsuario(){
		return cadUsuario;
	}
}
