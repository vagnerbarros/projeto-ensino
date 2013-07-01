
package ensino.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ensino.entidades.Aula;
import ensino.interfaces.IRepositorioAula;
import ensino.util.GerenteConexao;


public class RepositorioAula implements IRepositorioAula{

	public void cadastrar(Aula a){

		String sql = "insert into aula(id, descricao, material, nivel) values(?,?,?,?)";

		try {
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			montarOperacao(ps, a);

			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void remover(Aula a){

		String sql = "delete from aula where id = ?";

		try{
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			ps.setInt(1, a.getId());

			ps.executeUpdate();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public List<Aula> listar(){

		String sql = "Select * from aula";

		List<Aula> retorno = null;
		try {
			Statement st = GerenteConexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);
			retorno = new ArrayList<Aula>();

			while(rs.next()){
				Aula a = montarObjeto(rs);
				retorno.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public void editar(Aula a){
		String sql = "update aula set id=?, descricao =?, material =?, nivel =?  where id = "+a.getId();

		try {
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			montarOperacao(ps, a);

			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Aula buscarPorId(int id){
		String sql = "select * from aula where id = " + id;
		Aula a = null;

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
	
	public List<Aula> buscaLike(String campo, String valor){
		String sql = "Select * FROM aula WHERE " + campo + " like '%" + valor + "%'";

		List<Aula> retorno = null;
		try {
			Statement st = GerenteConexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);
			retorno = new ArrayList<Aula>();

			while(rs.next()){
				Aula a = montarObjeto(rs);
				retorno.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	private Aula montarObjeto(ResultSet rs){
		Aula a = new Aula();
		try {
			a.setId(rs.getInt("id"));
			a.setDescricao(rs.getString("descricao"));
			a.setMaterial(rs.getString("material"));
			a.setNivel(rs.getString("nivel"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return a;
	}
	
	private void montarOperacao(PreparedStatement ps, Aula a){

		try {
			ps.setInt(1, a.getId());
			ps.setString(2, a.getDescricao());
			ps.setString(3, a.getMaterial());
			ps.setString(4, a.getNivel());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
