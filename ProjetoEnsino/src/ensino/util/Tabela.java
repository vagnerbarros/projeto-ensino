package ensino.util;

import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ensino.entidades.Entidade;

public class Tabela<T extends Entidade> extends JTable{

	private DefaultTableModel model;
	private List<T> lista;
	
	public Tabela(String [] titulos){
		iniciarModel(titulos);
		this.setModel(model);
		configurar();
	}
	
	private void configurar(){
		
		//configurações
		this.getTableHeader().setReorderingAllowed(false);
		this.setCellSelectionEnabled(false);
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	private void iniciarModel(String [] titulos){
		
		model = new DefaultTableModel(new Object [][] { }, titulos){    
			
			         boolean[] canEdit = new boolean []{      
			             false, false, false  
			         };      
			        
			         @Override      
			         public boolean isCellEditable(int rowIndex, int columnIndex) {      
			             return canEdit [columnIndex];      
			         }    
			         
			         public Class getColumnClass(int column) {
			        	 return Object.class;
			         }
		};    
	}
	
	public void montarTabela(List<T> lista){
		limparTabela();
		this.lista = lista;
		for(int i = 0; i < lista.size(); i++){
			T t = lista.get(i);
			model.insertRow(i, t.getColunas());
		}
	}
	
	public void limparTabela(){
		while(model.getRowCount() > 0){
			model.removeRow(0);
		}
	}
	
	public DefaultTableModel getModel(){
		return model;
	}
	
	public void setModelTabela(DefaultTableModel m){
		model = m;
		this.setModel(m);
	}
}
