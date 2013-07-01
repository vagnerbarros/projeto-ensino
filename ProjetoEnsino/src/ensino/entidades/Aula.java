package ensino.entidades;

public class Aula implements Entidade{

	private int id;
	private String descricao;
	private String material;
	private String nivel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public Object[] getColunas() {
		return new Object [] {this, nivel, material};
	}
	public String toString(){
		return descricao;
	}
}
