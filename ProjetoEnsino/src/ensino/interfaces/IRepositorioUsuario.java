package ensino.interfaces;

import java.util.List;

import ensino.entidades.Usuario;

public interface IRepositorioUsuario {

	public void cadastrar(Usuario a);
	public void remover(Usuario a);
	public List<Usuario> listar();
	public void editar(Usuario a);
	public Usuario buscarPorId(int id);
	public List<Usuario> buscaLike(String campo, String valor);
	public Usuario logar(String login, String senha);
}
