package ensino.util;

import ensino.entidades.Usuario;


public abstract class Sessao {

	private static Usuario usuario;
	
	public static Usuario getUsuario(){
		return usuario;
	}
	
	public static void setUsuario(Usuario u){
		usuario = u;
	}
	
	public static void deslogar(){
		usuario = null;
	}
}
