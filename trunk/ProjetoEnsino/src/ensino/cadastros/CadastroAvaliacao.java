package ensino.cadastros;

import java.util.List;

import ensino.entidades.Avaliacao;
import ensino.interfaces.IRepositorioAvaliacao;

public class CadastroAvaliacao {

    private IRepositorioAvaliacao rep;
    
    public CadastroAvaliacao(IRepositorioAvaliacao rep){
    	this.rep = rep;
    }
    
    public void cadastrarAvaliacao(Avaliacao a){
        rep.cadastrar(a);
    }
    
    public void editarAvaliacao(Avaliacao a){
        rep.editar(a);
    }
    
    public List<Avaliacao> listarAvaliacao(){
        return rep.listar();
    }
    
    public void removerAvaliacao(Avaliacao a){
        rep.remover(a);
    }
    
    public Avaliacao buscarAvaliacaoPorId(int id){
    	return rep.buscarPorId(id);
    }
}

