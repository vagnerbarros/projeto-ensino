
package ensino.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ensino.entidades.Avaliacao;
import ensino.interfaces.IRepositorioAvaliacao;
import ensino.util.GerenteConexao;

public class RepositorioAvaliacao implements IRepositorioAvaliacao{

	public void cadastrar(Avaliacao a){

		String sql = "insert into avaliacao(id, nome, media, nivel) values(?,?,?,?)";

		try {
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			montarOperacao(ps, a);

			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void remover(Avaliacao a){

		String sql = "delete from avaliacao where id = ?";

		try{
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			ps.setInt(1, a.getId());

			ps.executeUpdate();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public List<Avaliacao> listar(){

		String sql = "Select * from avaliacao";

		List<Avaliacao> retorno = null;
		try {
			Statement st = GerenteConexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);
			retorno = new ArrayList<Avaliacao>();

			while(rs.next()){
				Avaliacao a = montarObjeto(rs);
				retorno.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public void editar(Avaliacao a){
		String sql = "update avaliacao set id=?, nome =?, media =?, nivel =?  where id = "+a.getId();

		try {
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			montarOperacao(ps, a);

			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Avaliacao buscarPorId(int id){
		String sql = "select * from avaliacao where id = " + id;
		Avaliacao a = null;

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
	
	public List<Avaliacao> buscaLike(String campo, String valor){
		String sql = "Select * FROM avaliacao WHERE " + campo + " like '%" + valor + "%'";

		List<Avaliacao> retorno = null;
		try {
			Statement st = GerenteConexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);
			retorno = new ArrayList<Avaliacao>();

			while(rs.next()){
				Avaliacao a = montarObjeto(rs);
				retorno.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	private Avaliacao montarObjeto(ResultSet rs){
		Avaliacao a = new Avaliacao();
		try {
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setMedia(rs.getString("media"));
			a.setNivel(rs.getString("nivel"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return a;
	}
	
	private void montarOperacao(PreparedStatement ps, Avaliacao a){

		try {
			ps.setInt(1, a.getId());
			ps.setString(2, a.getNome());
			ps.setString(3, a.getMedia());
			ps.setString(4, a.getNivel());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
