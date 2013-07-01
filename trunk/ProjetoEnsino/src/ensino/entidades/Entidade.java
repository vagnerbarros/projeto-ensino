package ensino.entidades;

public interface Entidade{

	//colunas que devem ser exibidas na tabela de listagem
	public Object [] getColunas();
	public boolean equals(Object o);
}
