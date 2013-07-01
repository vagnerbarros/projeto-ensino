
package ensino.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ensino.entidades.Usuario;
import ensino.interfaces.IRepositorioUsuario;
import ensino.util.GerenteConexao;


public class RepositorioUsuario implements IRepositorioUsuario{

	public void cadastrar(Usuario a){

		String sql = "insert into usuario(id, nome, email, login, senha, perfil, nivel) values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			montarOperacao(ps, a);

			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void remover(Usuario a){

		String sql = "delete from usuario where id = ?";

		try{
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			ps.setLong(1, a.getId());

			ps.executeUpdate();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public List<Usuario> listar(){

		String sql = "Select * from usuario";

		List<Usuario> retorno = null;
		try {
			Statement st = GerenteConexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);
			retorno = new ArrayList<Usuario>();

			while(rs.next()){
				Usuario a = montarObjeto(rs);
				retorno.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public void editar(Usuario a){
		String sql = "update usuario set id=?, nome =?, email =?, login =?, senha =?, perfil=?, nivel =?  where id = "+a.getId();

		try {
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			montarOperacao(ps, a);

			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Usuario buscarPorId(Long id){
		String sql = "select * from usuario where id = " + id;
		Usuario a = null;

		try{
			Statement st = GerenteConexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				a = montarObjeto(rs);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return a;
	}
	
	public List<Usuario> buscaLike(String campo, String valor){
		String sql = "Select * FROM usuario WHERE " + campo + " like '%" + valor + "%'";

		List<Usuario> retorno = null;
		try {
			Statement st = GerenteConexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);
			retorno = new ArrayList<Usuario>();

			while(rs.next()){
				Usuario a = montarObjeto(rs);
				retorno.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public Usuario logar(String login, String senha){
		String sql = "select * from usuario where login = '"+ login + "' AND senha = '" + senha + "'";
		Usuario a = null;

		try{
			Statement st = GerenteConexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				a = montarObjeto(rs);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return a;
	}
	
	private Usuario montarObjeto(ResultSet rs){
		Usuario a = new Usuario();
		try {
			a.setId(rs.getLong("id"));
			a.setNome(rs.getString("nome"));
			a.setEmail(rs.getString("email"));
			a.setLogin(rs.getString("login"));
			a.setSenha(rs.getString("senha"));
			a.setPerfil(rs.getString("perfil"));
			a.setNivel(rs.getInt("nivel"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return a;
	}
	
	private void montarOperacao(PreparedStatement ps, Usuario a){

		try {
			ps.setLong(1, a.getId());
			ps.setString(2, a.getNome());
			ps.setString(3, a.getEmail());
			ps.setString(4, a.getLogin());
			ps.setString(5, a.getSenha());
			ps.setString(6, a.getPerfil());
			ps.setInt(7, a.getNivel());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
