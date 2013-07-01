package ensino.entidades;

public class Questao {

	private int id;
	private String pergunta;
	private String [] alternativa;
	private String resposta;
	private int id_avaliacao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String[] getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(String[] alternativa) {
		this.alternativa = alternativa;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public int getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(int id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
}
