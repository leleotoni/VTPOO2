package Listeners;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import DAO.ReceitaDAO;
import Models.Receita;

public class TableReceitaListener implements TableModelListener{
	
	private DefaultTableModel model;
	private ReceitaDAO receitaDao;
	private JTable table;
	
	public TableReceitaListener(JTable table) throws SQLException {
		this.table = table;
		this.model = (DefaultTableModel) table.getModel();
		receitaDao = new ReceitaDAO();
	}
	
	private void updateTable(TableModelEvent tableChange) throws SQLException {
		System.out.println("Update");
		System.out.println(tableChange.getFirstRow());
		int rowChanged = tableChange.getFirstRow();
		ArrayList columnsValues = new ArrayList();
		for (int columnIndex = 0 ; columnIndex < this.model.getColumnCount() ;  columnIndex ++) {
			System.out.println(this.model.getValueAt(rowChanged, columnIndex));
			columnsValues.add(this.model.getValueAt(rowChanged, columnIndex));
		}
		Receita receita = new Receita(
				columnsValues.get(0).toString(),
				columnsValues.get(1).toString(),
				Boolean.parseBoolean(columnsValues.get(2).toString()),
				columnsValues.get(3).toString(),
				Boolean.parseBoolean(columnsValues.get(4).toString()),
				Integer.parseInt(columnsValues.get(5).toString()),
				columnsValues.get(6).toString()
				);
		
		System.out.println(receita.toString());
		receitaDao.updateReceitaById(rowChanged + 1, receita);
	
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		switch(e.getType()) {
		case TableModelEvent.UPDATE: try {
				this.updateTable(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		break;
		}
		
	}

}
