package ensino.interfaces;

import java.util.List;

import ensino.entidades.Avaliacao;

public interface IRepositorioAvaliacao {

	public void cadastrar(Avaliacao a);
	public void remover(Avaliacao a);
	public List<Avaliacao> listar();
	public void editar(Avaliacao a);
	public Avaliacao buscarPorId(int id);
	public List<Avaliacao> buscaLike(String campo, String valor);
}
