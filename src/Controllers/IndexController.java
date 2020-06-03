package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import DAO.ReceitaDAO;
import Views.CadastroReceitaView;
import Views.ExibirReceitaView;


public class IndexController implements ActionListener{

	private CadastroReceitaView cadastroView;
	private ExibirReceitaView exibirView;

	
	
	public IndexController(CadastroReceitaView cadastroView) {
		this.cadastroView = cadastroView;
	}
	public IndexController(ExibirReceitaView exibirView) {
		this.exibirView = exibirView;
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getActionCommand()){
		case "Cadastrar": this.abrirCadastroView();
		break;
		case "Exibir": try {
				this.abrirExibirView();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		}
	}
	
	
	private void abrirCadastroView() {
		cadastroView = new CadastroReceitaView();
		cadastroView.setVisible(true);
	}
	
	private void abrirExibirView() throws SQLException{
		exibirView = new ExibirReceitaView();
		exibirView.setVisible(true);
		ReceitaDAO receitaDao;
		try {
			receitaDao = new ReceitaDAO();
			System.out.println(receitaDao.getAllReceitas());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
