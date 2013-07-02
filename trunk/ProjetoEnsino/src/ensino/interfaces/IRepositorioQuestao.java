package ensino.interfaces;

import java.util.List;

import ensino.entidades.Questao;

public interface IRepositorioQuestao {

	public void cadastrar(Questao a);
	public void remover(Questao a);
	public List<Questao> listar();
	public void editar(Questao a);
	public Questao buscarPorId(int id);
	public List<Questao> buscaLike(String campo, String valor);
	public List<Questao> buscarPorIdAvaliacao(int idAvaliacao);
}
