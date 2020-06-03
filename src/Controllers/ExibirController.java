package Controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import DAO.ReceitaDAO;
import Listeners.TableReceitaListener;
import Models.Receita;
import Views.IndexView;

public class ExibirController implements ActionListener{

	public JTable table;
	public String column[]={"Nome","Ingrediente 1", "Possui este?", "Ingrediente 2", "Possui este?", "Nota", "Tipo"};    
	private DefaultTableModel model;
	
	public ExibirController(JTable table) throws SQLException{
		this.model = (DefaultTableModel) table.getModel();
		this.table = table;
		this.setTableColumns();
		this.getReceitas();
		table.getModel().addTableModelListener(new TableReceitaListener(table));
	}
	
	private void setTableColumns() {
		for (String columnName: this.column) {
			model.addColumn(columnName);
		}
	}
		
	public String getReceitas() {
				
		this.model.setRowCount(0);
		
		try {
			ReceitaDAO receitaDao = new ReceitaDAO();
			List<Receita> list = receitaDao.getAllReceitas();
			
			for (Receita receita : list) {
				model.addRow(new Object[] {
						receita.getNome(),
						receita.getIngrediente1(),
						receita.Possui1(),
						receita.getIngrediente2(),
						receita.Possui2(),
						receita.getNota(),
						receita.getTipo()
				});
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getActionCommand());
		switch(event.getActionCommand()) {
		case "Buscar": this.buscarReceita();
			break;
		case "Atualizar": this.atualizar();
			break;
		case "Voltar": this.voltar();
			break;
		}
	}
		
		private void buscarReceita() {
		// TODO Auto-generated method stub
			
	}

		public void atualizar()  {
			// TODO Auto-generated method stub
			this.getReceitas();
			}
		public void voltar() {
			
			IndexView index = new IndexView();
			
			index.setVisible(true);
		}


}
