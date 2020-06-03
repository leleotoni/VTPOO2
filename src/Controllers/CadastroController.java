package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import DAO.ReceitaDAO;
import Models.Receita;
import Views.ExibirReceitaView;
import Views.IndexView;

public class CadastroController implements ActionListener {

	private JTextField textNome;
	private JTextField textIngrediente1;
	private JCheckBox chPossui1;
	private JTextField textIngrediente2;
	private JCheckBox chPossui2;
	private JTextField textNota;
	private JComboBox<String> comboTipo;
	private List<Receita> listReceitas;
	
	public CadastroController(
			JTextField textNome,
			JTextField textIngrediente1,
			JCheckBox chPossui1,
			JTextField textIngrediente2,
			JCheckBox chPossui2,
			JComboBox<String> comboTipo,
			JTextField textNota) {
		
		this.textNome = textNome;
		this.textIngrediente1 = textIngrediente1;
		this.chPossui1 = chPossui1;
		this.textIngrediente2 = textIngrediente2;
		this.chPossui2 = chPossui2;
		this.textNota = textNota;
		
		listReceitas = new ArrayList<>();
		
		this.populateComboTipo(comboTipo);
	}
	
	private void populateComboTipo(JComboBox<String> comboTipo) {
		this.comboTipo = comboTipo;
		
		String[] tipos = new String[] {"Vegana", "Fitness", "Fatness"};
		for (String tipoLoop: tipos) {
			this.comboTipo.addItem(tipoLoop);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getActionCommand());
		switch(event.getActionCommand()) {
		case "Cadastrar": this.cadastrar();
			break;
		case "Limpar": this.limparCadastro();
			break;
		case "Exibir": try {
				this.exibirCadastro();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Voltar": this.voltarIndex();
			break;
		}
	}
	
	public void cadastrar() {
		// TODO Auto-generated method stub
		Receita receita = new Receita(
				this.textNome.getText(),
				this.textIngrediente1.getText(),
				this.chPossui1.isSelected(),
				this.textIngrediente2.getText(),
				this.chPossui2.isSelected(),
				Integer.parseInt(this.textNota.getText().toString()),
				this.comboTipo.getSelectedItem().toString()
				);
		listReceitas.add(receita);
		
		for (int i = 0 ; i <listReceitas.size(); i++) {
			System.out.println(listReceitas.get(i).toString());
		}
	}
	
	public void limparCadastro() {
		// TODO Auto-generated method stub
		this.textNome.setText("");
		this.textIngrediente1.setText("");
		this.chPossui1.setSelected(false);
		this.textIngrediente2.setText("");
		this.chPossui2.setSelected(false);
		this.textNota.setText("");
		this.comboTipo.setSelectedItem("");
	}

	public void exibirCadastro() throws SQLException {
		// TODO Auto-generated method stub
		ExibirReceitaView exibirView = new ExibirReceitaView();
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
	
	
	public void voltarIndex() {
		
		IndexView index = new IndexView();
		
		index.setVisible(true);
	}


	

	}
	
	
	


