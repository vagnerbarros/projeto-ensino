package ensino.cadastros;

import java.util.List;

import ensino.entidades.Aula;
import ensino.interfaces.IRepositorioAula;

public class CadastroAula {

    private IRepositorioAula rep;
    
    public CadastroAula(IRepositorioAula rep){
    	this.rep = rep;
    }
    
    public void cadastrarAula(Aula a){
        rep.cadastrar(a);
    }
    
    public void editarAula(Aula a){
        rep.editar(a);
    }
    
    public List<Aula> listarAulas(){
        return rep.listar();
    }
    
    public void removerAula(Aula a){
        rep.remover(a);
    }
    
    public Aula buscarAulaPorId(int id){
    	return rep.buscarPorId(id);
    }
    
    public List<Aula> buscarNivel(String nivel){
    	return rep.buscaLike("nivel", nivel);
    }
}

