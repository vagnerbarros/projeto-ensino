
package ensino.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ensino.entidades.Aula;
import ensino.entidades.Questao;
import ensino.interfaces.IRepositorioQuestao;
import ensino.util.GerenteConexao;


public class RepositorioQuestao implements IRepositorioQuestao{

	public void cadastrar(Questao a){

		String sql = "insert into questao(id, pergunta, alternativa_a, alternativa_b, " +
				"alternativa_c, alternativa_d, alternativa_e, resposta, id_avaliacao) values(?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			montarOperacao(ps, a);

			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void remover(Questao a){

		String sql = "delete from questao where id = ?";

		try{
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			ps.setInt(1, a.getId());

			ps.executeUpdate();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public List<Questao> listar(){

		String sql = "Select * from questao";

		List<Questao> retorno = null;
		try {
			Statement st = GerenteConexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);
			retorno = new ArrayList<Questao>();

			while(rs.next()){
				Questao a = montarObjeto(rs);
				retorno.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public void editar(Questao a){
		String sql = "update questao set id=?, pergunta =?, alternativa_a =?, alternativa_b =?," +
				"alternativa_c =?, alternativa_d =?, alternativa_e =?, resposta =?, id_avaliacao =?  where id = "+a.getId();

		try {
			PreparedStatement ps = GerenteConexao.getConexao().prepareStatement(sql);
			montarOperacao(ps, a);

			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Questao buscarPorId(int id){
		String sql = "select * from questao where id = " + id;
		Questao a = null;

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
	
	public List<Questao> buscaLike(String campo, String valor){
		String sql = "Select * FROM questao WHERE " + campo + " like '%" + valor + "%'";

		List<Questao> retorno = null;
		try {
			Statement st = GerenteConexao.getConexao().createStatement();
			ResultSet rs = st.executeQuery(sql);
			retorno = new ArrayList<Questao>();

			while(rs.next()){
				Questao a = montarObjeto(rs);
				retorno.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	private Questao montarObjeto(ResultSet rs){
		Questao a = new Questao();
		try {
			a.setId(rs.getInt("id"));
			a.setPergunta(rs.getString("pergunta"));
			String [] alternativas = {rs.getString("alternativa_a"), rs.getString("alternativa_b"),
			rs.getString("alternativa_c"), rs.getString("alternativa_d"), rs.getString("alternativa_e")};
			a.setAlternativa(alternativas);
			a.setResposta(rs.getString("resposta"));
			a.setId_avaliacao(rs.getInt("id_avaliacao"));
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return a;
	}
	
	private void montarOperacao(PreparedStatement ps, Questao a){

		try {
			String [] alternativas = a.getAlternativa();
			ps.setInt(1, a.getId());
			ps.setString(2, a.getPergunta());
			ps.setString(3, alternativas[0]);
			ps.setString(4, alternativas[1]);
			ps.setString(5, alternativas[2]);
			ps.setString(6, alternativas[3]);
			ps.setString(7, alternativas[4]);
			ps.setString(8, a.getResposta());
			ps.setInt(9, a.getId_avaliacao());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
