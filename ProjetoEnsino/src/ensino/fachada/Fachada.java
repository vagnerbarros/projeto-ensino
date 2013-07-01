
package ensino.fachada;

import ensino.cadastros.CadastroAula;
import ensino.cadastros.CadastroAvaliacao;
import ensino.cadastros.CadastroQuestao;
import ensino.cadastros.CadastroUsuario;
import ensino.interfaces.IRepositorioAula;
import ensino.interfaces.IRepositorioAvaliacao;
import ensino.interfaces.IRepositorioQuestao;
import ensino.interfaces.IRepositorioUsuario;
import ensino.repositorios.RepositorioAula;
import ensino.repositorios.RepositorioAvaliacao;
import ensino.repositorios.RepositorioQuestao;
import ensino.repositorios.RepositorioUsuario;

public class Fachada {

	private static Fachada instancia;
	private CadastroUsuario cadUsuario;
	private CadastroAula cadAula;
	private CadastroAvaliacao cadAvaliacao;
	private CadastroQuestao cadQuestao;

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
		
		IRepositorioAula repAula = new RepositorioAula();
		cadAula = new CadastroAula(repAula);
		
		IRepositorioAvaliacao repAvaliacao = new RepositorioAvaliacao();
		cadAvaliacao = new CadastroAvaliacao(repAvaliacao);
		
		IRepositorioQuestao repQuestao = new RepositorioQuestao();
		cadQuestao = new CadastroQuestao(repQuestao);
	}

	public CadastroUsuario cadastroUsuario(){
		return cadUsuario;
	}
	
	public CadastroAvaliacao cadastroAvaliacao(){
		return cadAvaliacao;
	}
	
	public CadastroAula cadastroAula(){
		return cadAula;
	}
	
	public CadastroQuestao cadastroQuestao(){
		return cadQuestao;
	}
}
