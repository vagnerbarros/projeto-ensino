package ensino.cadastros;

import java.util.List;

import ensino.dominio.Perfil;
import ensino.entidades.Usuario;
import ensino.interfaces.IRepositorioUsuario;

public class CadastroUsuario {

    private IRepositorioUsuario rep;
    
    public CadastroUsuario(IRepositorioUsuario rep){
    	this.rep = rep;
    }
    
    public void cadastrarAluno(Usuario a){
    	
    	//inicialmente o nivel do aluno é 1.
    	a.setNivel(1);
    	a.setPerfil(Perfil.ALUNO);
        rep.cadastrar(a);
    }
    
    public void editarUsuario(Usuario a){
        rep.editar(a);
    }
    
    public List<Usuario> listarUsuario(){
        return rep.listar();
    }
    
    public void removerUsuario(Usuario a){
        rep.remover(a);
    }
    
    public Usuario buscarUsuarioPorId(Long id){
    	return rep.buscarPorId(id);
    }
    
    public Usuario logar(String login, String senha){
    	return rep.logar(login, senha);
    }
}

