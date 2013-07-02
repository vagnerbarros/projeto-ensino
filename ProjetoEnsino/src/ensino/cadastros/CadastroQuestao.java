package ensino.cadastros;

import java.util.ArrayList;
import java.util.List;

import ensino.entidades.Questao;
import ensino.interfaces.IRepositorioQuestao;

public class CadastroQuestao {

    private IRepositorioQuestao rep;
    
    public CadastroQuestao(IRepositorioQuestao rep){
    	this.rep = rep;
    }
    
    public void cadastrarQuestao(Questao a){
        rep.cadastrar(a);
    }
    
    public void editarQuestao(Questao a){
        rep.editar(a);
    }
    
    public List<Questao> listarQuestao(){
        return rep.listar();
    }
    
    public void removerQuestao(Questao a){
        rep.remover(a);
    }
    
    public Questao buscarQuestaoPorId(int id){
    	return rep.buscarPorId(id);
    }
    
    public List<Questao> buscarPorAvaliacao(int idAvaliacao){
    	return rep.buscarPorIdAvaliacao(idAvaliacao);
    }
}

