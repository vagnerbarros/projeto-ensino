package ensino.interfaces;

import java.util.List;
import ensino.entidades.Aula;

public interface IRepositorioAula {

	public void cadastrar(Aula a);
	public void remover(Aula a);
	public List<Aula> listar();
	public void editar(Aula a);
	public Aula buscarPorId(int id);
	public List<Aula> buscaLike(String campo, String valor);
}
